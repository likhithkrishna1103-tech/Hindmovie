package f9;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f4334b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f4335c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f4336d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.c f4337a;

    public q0(p6.c cVar) {
        this.f4337a = cVar;
    }

    public static final String g(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        o8.u.g(atomicReference);
        o8.u.b(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        str2 = strArr3[i];
                        if (str2 == null) {
                            str2 = strArr2[i] + "(" + strArr[i] + ")";
                            strArr3[i] = str2;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4337a.v() ? str : g(str, h2.f4206c, h2.f4204a, f4334b);
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4337a.v() ? str : g(str, h2.f, h2.f4208e, f4335c);
    }

    public final String c(String str) {
        if (str == null) {
            return null;
        }
        return !this.f4337a.v() ? str : str.startsWith("_exp_") ? l0.e.k("experiment_id(", str, ")") : g(str, h2.f4211j, h2.i, f4336d);
    }

    public final String d(v vVar) {
        p6.c cVar = this.f4337a;
        if (!cVar.v()) {
            return vVar.toString();
        }
        StringBuilder sb = new StringBuilder("origin=");
        sb.append(vVar.f4443x);
        sb.append(",name=");
        sb.append(a(vVar.f4441v));
        sb.append(",params=");
        u uVar = vVar.f4442w;
        sb.append(uVar == null ? null : !cVar.v() ? uVar.f4426v.toString() : e(uVar.d()));
        return sb.toString();
    }

    public final String e(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f4337a.v()) {
            return bundle.toString();
        }
        StringBuilder sbB = y.e.b("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbB.length() != 8) {
                sbB.append(", ");
            }
            sbB.append(b(str));
            sbB.append("=");
            Object obj = bundle.get(str);
            sbB.append(obj instanceof Bundle ? f(new Object[]{obj}) : obj instanceof Object[] ? f((Object[]) obj) : obj instanceof ArrayList ? f(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbB.append("}]");
        return sbB.toString();
    }

    public final String f(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbB = y.e.b("[");
        for (Object obj : objArr) {
            String strE = obj instanceof Bundle ? e((Bundle) obj) : String.valueOf(obj);
            if (strE != null) {
                if (sbB.length() != 1) {
                    sbB.append(", ");
                }
                sbB.append(strE);
            }
        }
        sbB.append("]");
        return sbB.toString();
    }
}
