package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f773c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w0 f774a = w0.f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f775b;

    static {
        new q(0);
    }

    public q() {
    }

    public static void b(l lVar, p1 p1Var, int i, Object obj) {
        if (p1Var == p1.f769y) {
            lVar.Z(i, 3);
            ((a) obj).b(lVar);
            lVar.Z(i, 4);
        }
        lVar.Z(i, p1Var.f772w);
        switch (p1Var.ordinal()) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                lVar.T(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                lVar.R(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                lVar.d0(((Long) obj).longValue());
                break;
            case 3:
                lVar.d0(((Long) obj).longValue());
                break;
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                lVar.V(((Integer) obj).intValue());
                break;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                lVar.T(((Long) obj).longValue());
                break;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                lVar.R(((Integer) obj).intValue());
                break;
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                lVar.L(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                if (!(obj instanceof g)) {
                    lVar.Y((String) obj);
                } else {
                    lVar.P((g) obj);
                }
                break;
            case 9:
                ((a) obj).b(lVar);
                break;
            case 10:
                a aVar = (a) obj;
                lVar.getClass();
                lVar.b0(((v) aVar).a(null));
                aVar.b(lVar);
                break;
            case 11:
                if (!(obj instanceof g)) {
                    byte[] bArr = (byte[]) obj;
                    int length = bArr.length;
                    lVar.b0(length);
                    lVar.M(bArr, 0, length);
                } else {
                    lVar.P((g) obj);
                }
                break;
            case 12:
                lVar.b0(((Integer) obj).intValue());
                break;
            case 13:
                lVar.V(((Integer) obj).intValue());
                break;
            case 14:
                lVar.R(((Integer) obj).intValue());
                break;
            case 15:
                lVar.T(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                lVar.b0((iIntValue >> 31) ^ (iIntValue << 1));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                lVar.d0((jLongValue >> 63) ^ (jLongValue << 1));
                break;
        }
    }

    public final void a() {
        if (this.f775b) {
            return;
        }
        w0 w0Var = this.f774a;
        int size = w0Var.f803v.size();
        for (int i = 0; i < size; i++) {
            Map.Entry entryC = w0Var.c(i);
            if (entryC.getValue() instanceof v) {
                v vVar = (v) entryC.getValue();
                vVar.getClass();
                r0 r0Var = r0.f786c;
                r0Var.getClass();
                r0Var.a(vVar.getClass()).d(vVar);
                vVar.h();
            }
        }
        if (!w0Var.f805x) {
            if (w0Var.f803v.size() > 0) {
                w0Var.c(0).getKey().getClass();
                throw new ClassCastException();
            }
            Iterator it = w0Var.d().iterator();
            if (it.hasNext()) {
                ((Map.Entry) it.next()).getKey().getClass();
                throw new ClassCastException();
            }
        }
        if (!w0Var.f805x) {
            w0Var.f804w = w0Var.f804w.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.f804w);
            w0Var.f807z = w0Var.f807z.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(w0Var.f807z);
            w0Var.f805x = true;
        }
        this.f775b = true;
    }

    public final Object clone() {
        q qVar = new q();
        w0 w0Var = this.f774a;
        if (w0Var.f803v.size() > 0) {
            Map.Entry entryC = w0Var.c(0);
            if (entryC.getKey() != null) {
                throw new ClassCastException();
            }
            entryC.getValue();
            throw null;
        }
        Iterator it = w0Var.d().iterator();
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
            return this.f774a.equals(((q) obj).f774a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f774a.hashCode();
    }

    public q(int i) {
        a();
        a();
    }
}
