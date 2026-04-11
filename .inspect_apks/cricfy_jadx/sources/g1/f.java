package g1;

import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.s0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.x;
import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends v {
    private static final f DEFAULT_INSTANCE;
    private static volatile q0 PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private w strings_ = s0.f791y;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        v.j(f.class, fVar);
    }

    public static void l(f fVar, Set set) {
        w wVar = fVar.strings_;
        if (!((androidx.datastore.preferences.protobuf.b) wVar).f680v) {
            s0 s0Var = (s0) wVar;
            int i = s0Var.f793x;
            fVar.strings_ = s0Var.c(i == 0 ? 10 : i * 2);
        }
        RandomAccess randomAccess = fVar.strings_;
        Charset charset = x.f808a;
        if (randomAccess instanceof ArrayList) {
            ((ArrayList) randomAccess).ensureCapacity(set.size() + ((s0) randomAccess).f793x);
        }
        s0 s0Var2 = (s0) randomAccess;
        int i10 = s0Var2.f793x;
        for (Object obj : set) {
            if (obj == null) {
                String str = "Element at index " + (s0Var2.f793x - i10) + " is null.";
                for (int i11 = s0Var2.f793x - 1; i11 >= i10; i11--) {
                    s0Var2.remove(i11);
                }
                throw new NullPointerException(str);
            }
            s0Var2.add(obj);
        }
    }

    public static f m() {
        return DEFAULT_INSTANCE;
    }

    public static e o() {
        return (e) ((t) DEFAULT_INSTANCE.c(5));
    }

    @Override // androidx.datastore.preferences.protobuf.v
    public final Object c(int i) {
        q0 uVar;
        switch (y.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 3:
                return new f();
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new e(DEFAULT_INSTANCE);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return DEFAULT_INSTANCE;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                q0 q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (f.class) {
                    try {
                        uVar = PARSER;
                        if (uVar == null) {
                            uVar = new u();
                            PARSER = uVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return uVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final w n() {
        return this.strings_;
    }
}
