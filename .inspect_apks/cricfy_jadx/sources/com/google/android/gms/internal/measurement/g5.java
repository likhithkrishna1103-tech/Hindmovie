package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g5 implements a6 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g5 f2458b = new g5(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2459a;

    public /* synthetic */ g5(int i) {
        this.f2459a = i;
    }

    public static final y5 c(Object obj, Object obj2) {
        y5 y5VarA = (y5) obj;
        y5 y5Var = (y5) obj2;
        if (!y5Var.isEmpty()) {
            if (!y5VarA.f2736v) {
                y5VarA = y5VarA.a();
            }
            y5VarA.c();
            if (!y5Var.isEmpty()) {
                y5VarA.putAll(y5Var);
            }
        }
        return y5VarA;
    }

    @Override // com.google.android.gms.internal.measurement.a6
    public boolean a(Class cls) {
        switch (this.f2459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return i5.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.internal.measurement.a6
    public i6 b(Class cls) {
        switch (this.f2459a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (!i5.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (i6) i5.l(cls.asSubclass(i5.class)).o(3);
                } catch (Exception e9) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e9);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }
}
