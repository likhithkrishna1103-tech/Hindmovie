package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements k0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s f789b = new s(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f790a;

    public /* synthetic */ s(int i) {
        this.f790a = i;
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final t0 a(Class cls) {
        switch (this.f790a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!v.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (t0) v.d(cls.asSubclass(v.class)).c(3);
                } catch (Exception e9) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // androidx.datastore.preferences.protobuf.k0
    public final boolean b(Class cls) {
        switch (this.f790a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return v.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
