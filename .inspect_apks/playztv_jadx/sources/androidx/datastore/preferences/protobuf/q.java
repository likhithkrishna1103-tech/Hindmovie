package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f1100c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d1 f1101a = new d1(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1102b;

    static {
        new q(0);
    }

    public q() {
    }

    public static void b(k kVar, a2 a2Var, int i, Object obj) throws IOException {
        if (a2Var == a2.f1006x) {
            kVar.R(i, 3);
            ((a) obj).c(kVar);
            kVar.R(i, 4);
        }
        kVar.R(i, a2Var.f1010v);
        switch (a2Var.ordinal()) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                kVar.L(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                kVar.J(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                kVar.V(((Long) obj).longValue());
                break;
            case 3:
                kVar.V(((Long) obj).longValue());
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                kVar.N(((Integer) obj).intValue());
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                kVar.L(((Long) obj).longValue());
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                kVar.J(((Integer) obj).intValue());
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                kVar.D(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof g)) {
                    kVar.Q((String) obj);
                } else {
                    kVar.H((g) obj);
                }
                break;
            case 9:
                ((a) obj).c(kVar);
                break;
            case 10:
                a aVar = (a) obj;
                kVar.getClass();
                kVar.T(aVar.a());
                aVar.c(kVar);
                break;
            case 11:
                if (!(obj instanceof g)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    kVar.T(length);
                    kVar.E(bArr, 0, length);
                } else {
                    kVar.H((g) obj);
                }
                break;
            case 12:
                kVar.T(((Integer) obj).intValue());
                break;
            case 13:
                kVar.N(((Integer) obj).intValue());
                break;
            case 14:
                kVar.J(((Integer) obj).intValue());
                break;
            case 15:
                kVar.L(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                kVar.T((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                kVar.V((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.f1102b) {
            return;
        }
        d1 d1Var = this.f1101a;
        if (!d1Var.f1034x) {
            if (d1Var.f1032v.size() > 0) {
                d1Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = d1Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!d1Var.f1034x) {
            d1Var.f1033w = d1Var.f1033w.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(d1Var.f1033w);
            d1Var.f1036z = d1Var.f1036z.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(d1Var.f1036z);
            d1Var.f1034x = true;
        }
        this.f1102b = true;
    }

    public final Object clone() {
        q qVar = new q();
        d1 d1Var = this.f1101a;
        if (d1Var.f1032v.size() > 0) {
            Map.Entry entryC = d1Var.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = d1Var.d().iterator();
        if (!it.hasNext()) {
            return qVar;
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
        if (obj instanceof q) {
            return this.f1101a.equals(((q) obj).f1101a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1101a.hashCode();
    }

    public q(int i) {
        a();
        a();
    }
}
