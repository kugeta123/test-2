$a = 100;
sub sfunction {
    return $a;
}

sub static {
    my $a = 101;
    return sfunction();
}

print "static result:  ", static(), "\n";

$b = 100;
sub dfunction {
    return $b;
}

sub dynamic {
    local $b = 101;
    return dfunction();
}

print "dynamic result:  ", dynamic(), "\n";