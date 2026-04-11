package g1;

import androidx.datastore.preferences.protobuf.a1;
import androidx.datastore.preferences.protobuf.h0;
import androidx.datastore.preferences.protobuf.k;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.t;
import androidx.datastore.preferences.protobuf.t0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.u0;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.z;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends v {
    private static final d DEFAULT_INSTANCE;
    private static volatile q0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private h0 preferences_ = h0.f714w;

    static {
        d dVar = new d();
        DEFAULT_INSTANCE = dVar;
        v.j(d.class, dVar);
    }

    public static h0 l(d dVar) {
        h0 h0Var = dVar.preferences_;
        if (!h0Var.f715v) {
            dVar.preferences_ = h0Var.b();
        }
        return dVar.preferences_;
    }

    public static b n() {
        return (b) ((t) DEFAULT_INSTANCE.c(5));
    }

    public static d o(FileInputStream fileInputStream) throws z {
        d dVar = DEFAULT_INSTANCE;
        androidx.datastore.preferences.protobuf.i iVar = new androidx.datastore.preferences.protobuf.i(fileInputStream);
        n nVarA = n.a();
        v vVarI = dVar.i();
        try {
            r0 r0Var = r0.f786c;
            r0Var.getClass();
            u0 u0VarA = r0Var.a(vVarI.getClass());
            k kVar = (k) iVar.f730b;
            if (kVar == null) {
                kVar = new k(iVar);
            }
            u0VarA.g(vVarI, kVar, nVarA);
            u0VarA.d(vVarI);
            if (v.f(vVarI, true)) {
                return (d) vVarI;
            }
            throw new z(new a1().getMessage());
        } catch (a1 e9) {
            throw new z(e9.getMessage());
        } catch (z e10) {
            if (e10.f818v) {
                throw new z(e10.getMessage(), e10);
            }
            throw e10;
        } catch (IOException e11) {
            if (e11.getCause() instanceof z) {
                throw ((z) e11.getCause());
            }
            throw new z(e11.getMessage(), e11);
        } catch (RuntimeException e12) {
            if (e12.getCause() instanceof z) {
                throw ((z) e12.getCause());
            }
            throw e12;
        }
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
                return new t0(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", c.f4613a});
            case 3:
                return new d();
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new b(DEFAULT_INSTANCE);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return DEFAULT_INSTANCE;
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                q0 q0Var = PARSER;
                if (q0Var != null) {
                    return q0Var;
                }
                synchronized (d.class) {
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

    public final Map m() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
