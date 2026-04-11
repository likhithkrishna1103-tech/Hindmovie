package nb;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import qb.s0;
import qb.t0;
import qb.u0;
import qb.w0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public static final HashMap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f8991g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f8993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final hd.e f8994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final vb.b f8995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d8.j f8996e;

    static {
        HashMap map = new HashMap();
        f = map;
        l0.e.q(5, map, "armeabi", 6, "armeabi-v7a");
        l0.e.q(9, map, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
        Locale locale = Locale.US;
        f8991g = "Crashlytics Android SDK/20.0.4";
    }

    public q(Context context, v vVar, hd.e eVar, vb.b bVar, d8.j jVar) {
        this.f8992a = context;
        this.f8993b = vVar;
        this.f8994c = eVar;
        this.f8995d = bVar;
        this.f8996e = jVar;
    }

    public static t0 c(nc.p pVar, int i) {
        String str = (String) pVar.f9070b;
        String str2 = (String) pVar.f9069a;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pVar.f9071c;
        int i10 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        nc.p pVar2 = (nc.p) pVar.f9072d;
        if (i >= 8) {
            nc.p pVar3 = pVar2;
            while (pVar3 != null) {
                pVar3 = (nc.p) pVar3.f9072d;
                i10++;
            }
        }
        int i11 = i10;
        List listD = d(stackTraceElementArr, 4);
        if (listD == null) {
            throw new NullPointerException("Null frames");
        }
        byte b8 = (byte) (0 | 1);
        t0 t0VarC = null;
        if (pVar2 != null && i11 == 0) {
            t0VarC = c(pVar2, i + 1);
        }
        if (b8 == 1) {
            return new t0(str, str2, listD, t0VarC, i11);
        }
        StringBuilder sb = new StringBuilder();
        if ((b8 & 1) == 0) {
            sb.append(" overflowCount");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    public static List d(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            w0 w0Var = new w0();
            w0Var.f10761e = i;
            w0Var.f = (byte) (w0Var.f | 4);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            w0Var.f10757a = jMax;
            byte b8 = (byte) (w0Var.f | 1);
            w0Var.f = b8;
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            w0Var.f10758b = str;
            w0Var.f10759c = fileName;
            w0Var.f10760d = lineNumber;
            w0Var.f = (byte) (b8 | 2);
            arrayList.add(w0Var.a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static u0 e() {
        byte b8 = (byte) 1;
        if (b8 == 1) {
            return new u0(0L, "0", "0");
        }
        StringBuilder sb = new StringBuilder();
        if (b8 == 0) {
            sb.append(" address");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    public final List a() {
        byte b8 = (byte) (((byte) (0 | 1)) | 2);
        hd.e eVar = this.f8994c;
        String str = (String) eVar.f5929e;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        String str2 = (String) eVar.f5926b;
        if (b8 == 3) {
            return Collections.singletonList(new s0(0L, 0L, str, str2));
        }
        StringBuilder sb = new StringBuilder();
        if ((b8 & 1) == 0) {
            sb.append(" baseAddress");
        }
        if ((b8 & 2) == 0) {
            sb.append(" size");
        }
        throw new IllegalStateException(l0.e.l("Missing required properties:", sb));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final qb.b1 b(int r17) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.q.b(int):qb.b1");
    }
}
