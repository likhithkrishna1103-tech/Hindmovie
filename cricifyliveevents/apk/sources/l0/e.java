package l0;

import androidx.fragment.app.r0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import ua.f0;
import ua.i0;
import x3.o;
import x3.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class e {
    public static x3.d a(p pVar, byte[] bArr, int i) {
        f0 f0VarJ = i0.j();
        pVar.C(bArr, 0, i, o.f14314c, new kb.d(20, f0VarJ));
        return new x3.d(f0VarJ.g());
    }

    public static int b(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return w(str);
        } catch (IllegalArgumentException unused) {
            return 0;
        }
    }

    public static /* synthetic */ int c(int i) {
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

    public static /* synthetic */ boolean d(int i) {
        if (i == 1 || i == 2 || i == 3) {
            return false;
        }
        if (i == 4 || i == 5) {
            return true;
        }
        throw null;
    }

    public static int e(int i, int i10, String str) {
        return (str.hashCode() + i) * i10;
    }

    public static androidx.fragment.app.a f(r0 r0Var, r0 r0Var2) {
        r0Var.getClass();
        return new androidx.fragment.app.a(r0Var2);
    }

    public static String g(int i, String str) {
        return str + i;
    }

    public static String h(int i, String str, String str2) {
        return str + i + str2;
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.B());
        return sb.toString();
    }

    public static String j(String str, String str2) {
        return str + str2;
    }

    public static String k(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String l(String str, StringBuilder sb) {
        return str + ((Object) sb);
    }

    public static StringBuilder m(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static HashMap n(Class cls, dc.a aVar) {
        HashMap map = new HashMap();
        map.put(cls, aVar);
        return map;
    }

    public static Map o(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static void p(int i, String str, String str2) {
        y1.b.p(str2, str + i);
    }

    public static void q(int i, HashMap map, String str, int i10, String str2) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i10));
    }

    public static void r(String str, String str2, String str3) {
        y1.b.p(str3, str + str2);
    }

    public static void s(v1.o oVar, a3.i0 i0Var) {
        i0Var.f(new v1.p(oVar));
    }

    public static void t(l2.h hVar, l2.h hVar2) {
        if (hVar == hVar2) {
            return;
        }
        if (hVar2 != null) {
            hVar2.d(null);
        }
        if (hVar != null) {
            hVar.c(null);
        }
    }

    public static /* synthetic */ String u(int i) {
        switch (i) {
            case 1:
                return "BEGIN_ARRAY";
            case 2:
                return "END_ARRAY";
            case 3:
                return "BEGIN_OBJECT";
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "END_OBJECT";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "NAME";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "STRING";
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return "NUMBER";
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                return "BOOLEAN";
            case 9:
                return "NULL";
            case 10:
                return "END_DOCUMENT";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String v(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "MEMORY_CACHE" : "RESOURCE_DISK_CACHE" : "DATA_DISK_CACHE" : "REMOTE" : "LOCAL";
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
