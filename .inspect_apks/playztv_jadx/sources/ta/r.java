package ta;

import android.content.Context;
import h4.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import wa.s0;
import wa.t0;
import wa.u0;
import wa.w0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r {
    public static final HashMap f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f12417g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f12419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final dd.h f12420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z f12421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b7.s f12422e;

    static {
        HashMap map = new HashMap();
        f = map;
        e6.j.q(5, map, "armeabi", 6, "armeabi-v7a");
        e6.j.q(9, map, "arm64-v8a", 0, "x86");
        map.put("x86_64", 1);
        Locale locale = Locale.US;
        f12417g = "Crashlytics Android SDK/19.2.0";
    }

    public r(Context context, v vVar, dd.h hVar, z zVar, b7.s sVar) {
        this.f12418a = context;
        this.f12419b = vVar;
        this.f12420c = hVar;
        this.f12421d = zVar;
        this.f12422e = sVar;
    }

    public static t0 c(ub.o oVar, int i) {
        String str = (String) oVar.f12869w;
        String str2 = (String) oVar.f12868v;
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) oVar.f12870x;
        int i10 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        ub.o oVar2 = (ub.o) oVar.f12871y;
        if (i >= 8) {
            ub.o oVar3 = oVar2;
            while (oVar3 != null) {
                oVar3 = (ub.o) oVar3.f12871y;
                i10++;
            }
        }
        int i11 = i10;
        List listD = d(stackTraceElementArr, 4);
        if (listD == null) {
            throw new NullPointerException("Null frames");
        }
        byte b10 = (byte) (0 | 1);
        t0 t0VarC = null;
        if (oVar2 != null && i11 == 0) {
            t0VarC = c(oVar2, i + 1);
        }
        if (b10 == 1) {
            return new t0(str, str2, listD, t0VarC, i11);
        }
        StringBuilder sb2 = new StringBuilder();
        if ((b10 & 1) == 0) {
            sb2.append(" overflowCount");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }

    public static List d(StackTraceElement[] stackTraceElementArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            w0 w0Var = new w0();
            w0Var.f14058e = i;
            w0Var.f = (byte) (w0Var.f | 4);
            long lineNumber = 0;
            long jMax = stackTraceElement.isNativeMethod() ? Math.max(stackTraceElement.getLineNumber(), 0L) : 0L;
            String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
            String fileName = stackTraceElement.getFileName();
            if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
                lineNumber = stackTraceElement.getLineNumber();
            }
            w0Var.f14054a = jMax;
            byte b10 = (byte) (w0Var.f | 1);
            w0Var.f = b10;
            if (str == null) {
                throw new NullPointerException("Null symbol");
            }
            w0Var.f14055b = str;
            w0Var.f14056c = fileName;
            w0Var.f14057d = lineNumber;
            w0Var.f = (byte) (b10 | 2);
            arrayList.add(w0Var.a());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static u0 e() {
        byte b10 = (byte) 1;
        if (b10 == 1) {
            return new u0(0L, "0", "0");
        }
        StringBuilder sb2 = new StringBuilder();
        if (b10 == 0) {
            sb2.append(" address");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }

    public final List a() {
        byte b10 = (byte) (((byte) (0 | 1)) | 2);
        dd.h hVar = this.f12420c;
        String str = (String) hVar.f4155e;
        if (str == null) {
            throw new NullPointerException("Null name");
        }
        String str2 = (String) hVar.f4152b;
        if (b10 == 3) {
            return Collections.singletonList(new s0(0L, 0L, str, str2));
        }
        StringBuilder sb2 = new StringBuilder();
        if ((b10 & 1) == 0) {
            sb2.append(" baseAddress");
        }
        if ((b10 & 2) == 0) {
            sb2.append(" size");
        }
        throw new IllegalStateException(e6.j.o("Missing required properties:", sb2));
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final wa.b1 b(int r17) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ta.r.b(int):wa.b1");
    }
}
