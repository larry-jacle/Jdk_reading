package com.jacle.jdk.default_package;

public interface DefaultInterface
{
    public default int testDefaultDecoration()
    {
        return 1;
    }
}
