package b1;

import androidx.datastore.preferences.protobuf.a1;
import androidx.datastore.preferences.protobuf.b0;
import androidx.datastore.preferences.protobuf.b1;
import androidx.datastore.preferences.protobuf.n;
import androidx.datastore.preferences.protobuf.n0;
import androidx.datastore.preferences.protobuf.u;
import androidx.datastore.preferences.protobuf.v;
import androidx.datastore.preferences.protobuf.w;
import androidx.datastore.preferences.protobuf.w0;
import androidx.datastore.preferences.protobuf.y0;
import androidx.datastore.preferences.protobuf.z;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f extends w {
    private static final f DEFAULT_INSTANCE;
    private static volatile w0 PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private n0 preferences_ = n0.f1092v;

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        w.h(f.class, fVar);
    }

    public static n0 i(f fVar) {
        n0 n0Var = fVar.preferences_;
        if (!n0Var.f1093u) {
            fVar.preferences_ = n0Var.b();
        }
        return fVar.preferences_;
    }

    public static d k() {
        return (d) ((u) DEFAULT_INSTANCE.d(5));
    }

    public static f l(FileInputStream fileInputStream) {
        f fVar = DEFAULT_INSTANCE;
        androidx.datastore.preferences.protobuf.h hVar = new androidx.datastore.preferences.protobuf.h(fileInputStream);
        n nVarA = n.a();
        w wVar = (w) fVar.d(4);
        try {
            y0 y0Var = y0.f1144c;
            y0Var.getClass();
            b1 b1VarA = y0Var.a(wVar.getClass());
            androidx.datastore.preferences.protobuf.i iVar = hVar.f1051b;
            if (iVar == null) {
                iVar = new androidx.datastore.preferences.protobuf.i();
                iVar.f1066c = 0;
                Charset charset = z.f1147a;
                iVar.f1067d = hVar;
                hVar.f1051b = iVar;
            }
            b1VarA.g(wVar, iVar, nVarA);
            b1VarA.c(wVar);
            if (wVar.g()) {
                return (f) wVar;
            }
            throw new b0(new a2.y0().getMessage());
        } catch (IOException e10) {
            if (e10.getCause() instanceof b0) {
                throw ((b0) e10.getCause());
            }
            throw new b0(e10.getMessage());
        } catch (RuntimeException e11) {
            if (e11.getCause() instanceof b0) {
                throw ((b0) e11.getCause());
            }
            throw e11;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.w
    public final Object d(int i) {
        w0 vVar;
        switch (v.e.c(i)) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return new a1(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", e.f1718a});
            case 3:
                return new f();
            case j.LONG_FIELD_NUMBER /* 4 */:
                return new d(DEFAULT_INSTANCE);
            case j.STRING_FIELD_NUMBER /* 5 */:
                return DEFAULT_INSTANCE;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                w0 w0Var = PARSER;
                if (w0Var != null) {
                    return w0Var;
                }
                synchronized (f.class) {
                    try {
                        vVar = PARSER;
                        if (vVar == null) {
                            vVar = new v();
                            PARSER = vVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    break;
                }
                return vVar;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final Map j() {
        return Collections.unmodifiableMap(this.preferences_);
    }
}
