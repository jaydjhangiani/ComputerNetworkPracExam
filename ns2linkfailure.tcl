set ns [new Simulator]
$ns rtproto DV
set nf [open out.nam w]
$ns nametrace-all $nf

proc finish{}{
    global ns nf
    $ns flush-trace
    close $nf
    exec nam out.nam &
    exit0
}

for{set i 0}{$i<7}{incr i}{
    set n($i) [$ns node]
}

for{set i 0}{$i<7}{incr i}{
    $ns duplex-link $n($i) $n([expr($i+1)%7]) 1Mb 10ms DropTail
}

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_500
$cbr0 set interval_0.005
$cbr0 attach-agent $udp0

set null0 [new Agent/Null]
$ns attach-agent $n3 $null0
$ns connect $udp0 $null0

$ns at 0.5 "$cbr0 start"
$ns at 4.5 "$cbr0 stop"

$ns rtmodel-at 1.0 down $n1 $n2
$ns rtmodel-at 2.0 up $ns1 $ns2

$ns at 5.0 "finish"
$ns run