package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class r5 extends IOException {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f3179u = 0;

    public static r5 a() {
        return new r5("Protocol message had invalid UTF-8.");
    }

    public static r5 b() {
        return new r5("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static r5 c() {
        return new r5("Failed to parse the message.");
    }

    public static r5 d() {
        return new r5("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
