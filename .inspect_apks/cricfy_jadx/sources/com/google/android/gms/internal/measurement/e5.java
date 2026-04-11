package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e5 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f2377c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l6 f2378a = new l6();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2379b;

    static {
        new e5(0);
    }

    public e5() {
    }

    public static void b(b5 b5Var, v6 v6Var, int i, Object obj) throws a2.a {
        if (v6Var == v6.f2667y) {
            Charset charset = p5.f2570a;
            b5Var.g0(i, 3);
            ((i5) ((u4) obj)).d(b5Var);
            b5Var.g0(i, 4);
            return;
        }
        b5Var.g0(i, v6Var.f2670w);
        w6 w6Var = w6.f2710v;
        switch (v6Var.ordinal()) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                b5Var.s0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                b5Var.q0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                b5Var.r0(((Long) obj).longValue());
                break;
            case 3:
                b5Var.r0(((Long) obj).longValue());
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                b5Var.o0(((Integer) obj).intValue());
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                b5Var.s0(((Long) obj).longValue());
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                b5Var.q0(((Integer) obj).intValue());
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                b5Var.n0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                if (!(obj instanceof a5)) {
                    b5Var.u0((String) obj);
                } else {
                    b5Var.m0((a5) obj);
                }
                break;
            case 9:
                ((i5) ((u4) obj)).d(b5Var);
                break;
            case 10:
                b5Var.getClass();
                i5 i5Var = (i5) ((u4) obj);
                b5Var.p0(i5Var.k());
                i5Var.d(b5Var);
                break;
            case 11:
                if (!(obj instanceof a5)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    b5Var.p0(length);
                    b5Var.t0(length, bArr);
                } else {
                    b5Var.m0((a5) obj);
                }
                break;
            case 12:
                b5Var.p0(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof k5)) {
                    b5Var.o0(((Integer) obj).intValue());
                } else {
                    b5Var.o0(((k5) obj).a());
                }
                break;
            case 14:
                b5Var.q0(((Integer) obj).intValue());
                break;
            case 15:
                b5Var.s0(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                b5Var.p0((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                b5Var.r0((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    public final void a() {
        if (this.f2379b) {
            return;
        }
        l6 l6Var = this.f2378a;
        int i = l6Var.f2517w;
        for (int i10 = 0; i10 < i; i10++) {
            Object obj = l6Var.a(i10).f2531w;
            if (obj instanceof i5) {
                ((i5) obj).g();
            }
        }
        Iterator it = l6Var.b().iterator();
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            if (value instanceof i5) {
                ((i5) value).g();
            }
        }
        if (!l6Var.f2519y) {
            if (l6Var.f2517w > 0) {
                l6Var.a(0).f2530v.getClass();
                throw new ClassCastException();
            }
            Iterator it2 = l6Var.b().iterator();
            if (it2.hasNext()) {
                ((Map.Entry) it2.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!l6Var.f2519y) {
            l6Var.f2518x = l6Var.f2518x.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(l6Var.f2518x);
            l6Var.A = l6Var.A.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(l6Var.A);
            l6Var.f2519y = true;
        }
        this.f2379b = true;
    }

    public final Object clone() {
        e5 e5Var = new e5();
        l6 l6Var = this.f2378a;
        if (l6Var.f2517w > 0) {
            l6Var.a(0).f2530v.getClass();
            throw new ClassCastException();
        }
        Iterator it = l6Var.b().iterator();
        if (!it.hasNext()) {
            return e5Var;
        }
        Map.Entry entry = (Map.Entry) it.next();
        if (entry.getKey() != null) {
            throw new ClassCastException();
        }
        entry.getValue();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e5) {
            return this.f2378a.equals(((e5) obj).f2378a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2378a.hashCode();
    }

    public e5(int i) {
        a();
        a();
    }
}
