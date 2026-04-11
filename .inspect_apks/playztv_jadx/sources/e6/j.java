package e6;

import aa.j0;
import androidx.fragment.app.n0;
import androidx.recyclerview.widget.RecyclerView;
import java.nio.ByteBuffer;
import java.util.HashMap;
import w2.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class j {
    public static t3.b a(t3.m mVar, byte[] bArr, int i) {
        aa.g0 g0VarN = j0.n();
        mVar.n(bArr, 0, i, t3.l.f12093c, new nc.c(10, g0VarN));
        return new t3.b(g0VarN.g());
    }

    public static void b(h0 h0Var, s1.u uVar, int i) {
        h0Var.b(uVar, i, 0);
    }

    public static int c(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return w(str);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static long d(w1.o oVar) {
        byte[] bArr = (byte[]) ((w1.p) oVar).f13552b.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }

    public static /* synthetic */ int e(int i) {
        int i10 = 1;
        if (i != 1) {
            i10 = 2;
            if (i != 2) {
                i10 = 3;
                if (i != 3) {
                    if (i == 4) {
                        return 4;
                    }
                    throw null;
                }
            }
        }
        return i10;
    }

    public static /* synthetic */ boolean f(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static float g(float f, float f4, float f10, float f11) {
        return ((f - f4) * f10) + f11;
    }

    public static int h(int i, int i10, String str) {
        return (str.hashCode() + i) * i10;
    }

    public static androidx.fragment.app.a i(n0 n0Var, n0 n0Var2) {
        n0Var.getClass();
        return new androidx.fragment.app.a(n0Var2);
    }

    public static String j(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String k(RecyclerView recyclerView, StringBuilder sb2) {
        sb2.append(recyclerView.B());
        return sb2.toString();
    }

    public static String l(String str, int i) {
        return str + i;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String o(String str, StringBuilder sb2) {
        return str + ((Object) sb2);
    }

    public static void p(int i, String str, String str2) {
        s1.b.p(str2, str + i);
    }

    public static void q(int i, HashMap map, String str, int i10, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i10));
    }

    public static void r(String str, String str2, String str3) {
        s1.b.p(str3, str + str2);
    }

    public static void s(p1.p pVar, h0 h0Var) {
        h0Var.d(new p1.q(pVar));
    }

    public static void t(f2.h hVar, f2.h hVar2) {
        if (hVar == hVar2) {
            return;
        }
        if (hVar2 != null) {
            hVar2.b(null);
        }
        if (hVar != null) {
            hVar.c(null);
        }
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "INITIALIZE";
            case 2:
                return "RESOURCE_CACHE";
            case 3:
                return "DATA_CACHE";
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return "SOURCE";
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return "ENCODE";
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return "FINISHED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String v(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return "END_OBJECT";
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return "NAME";
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return "STRING";
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return "NUMBER";
            case 8:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ int w(String str) {
        if (str == null) {
            throw new NullPointerException("Name is null");
        }
        if (str.equals("GET")) {
            return 1;
        }
        if (str.equals("PUT")) {
            return 2;
        }
        if (str.equals("POST")) {
            return 3;
        }
        if (str.equals("DELETE")) {
            return 4;
        }
        if (str.equals("HEAD")) {
            return 5;
        }
        if (str.equals("OPTIONS")) {
            return 6;
        }
        if (str.equals("TRACE")) {
            return 7;
        }
        if (str.equals("CONNECT")) {
            return 8;
        }
        if (str.equals("PATCH")) {
            return 9;
        }
        if (str.equals("PROPFIND")) {
            return 10;
        }
        if (str.equals("PROPPATCH")) {
            return 11;
        }
        if (str.equals("MKCOL")) {
            return 12;
        }
        if (str.equals("MOVE")) {
            return 13;
        }
        if (str.equals("COPY")) {
            return 14;
        }
        if (str.equals("LOCK")) {
            return 15;
        }
        if (str.equals("UNLOCK")) {
            return 16;
        }
        throw new IllegalArgumentException("No enum constant fi.iki.elonen.NanoHTTPD.Method.".concat(str));
    }
}
