package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class z extends IOException {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f818v;

    public static z a() {
        return new z("Protocol message had invalid UTF-8.");
    }

    public static y b() {
        return new y("Protocol message tag had invalid wire type.");
    }

    public static z c() {
        return new z("CodedInputStream encountered a malformed varint.");
    }

    public static z d() {
        return new z("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static z e() {
        return new z("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
