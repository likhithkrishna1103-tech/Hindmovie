package k8;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference f7297b = new AtomicReference();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicReference f7298c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicReference f7299d = new AtomicReference();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a1 f7300a;

    public l0(a1 a1Var) {
        this.f7300a = a1Var;
    }

    public static String c(String str, String[] strArr, String[] strArr2, AtomicReference atomicReference) {
        String str2;
        t7.v.h(atomicReference);
        t7.v.a(strArr.length == strArr2.length);
        for (int i = 0; i < strArr.length; i++) {
            if (Objects.equals(str, strArr[i])) {
                synchronized (atomicReference) {
                    try {
                        String[] strArr3 = (String[]) atomicReference.get();
                        if (strArr3 == null) {
                            strArr3 = new String[strArr2.length];
                            atomicReference.set(strArr3);
                        }
                        if (strArr3[i] == null) {
                            strArr3[i] = strArr2[i] + "(" + strArr[i] + ")";
                        }
                        str2 = strArr3[i];
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return str2;
            }
        }
        return str;
    }

    public final String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.f7300a.b()) {
            return bundle.toString();
        }
        StringBuilder sbB = v.e.b("Bundle[{");
        for (String str : bundle.keySet()) {
            if (sbB.length() != 8) {
                sbB.append(", ");
            }
            sbB.append(f(str));
            sbB.append("=");
            Object obj = bundle.get(str);
            sbB.append(obj instanceof Bundle ? e(new Object[]{obj}) : obj instanceof Object[] ? e((Object[]) obj) : obj instanceof ArrayList ? e(((ArrayList) obj).toArray()) : String.valueOf(obj));
        }
        sbB.append("}]");
        return sbB.toString();
    }

    public final String b(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7300a.b() ? str : c(str, c2.f7112c, c2.f7110a, f7297b);
    }

    public final String d(v vVar) {
        a1 a1Var = this.f7300a;
        if (!a1Var.b()) {
            return vVar.toString();
        }
        StringBuilder sb2 = new StringBuilder("origin=");
        sb2.append(vVar.f7446w);
        sb2.append(",name=");
        sb2.append(b(vVar.f7444u));
        sb2.append(",params=");
        u uVar = vVar.f7445v;
        sb2.append(uVar == null ? null : !a1Var.b() ? uVar.f7434u.toString() : a(uVar.d()));
        return sb2.toString();
    }

    public final String e(Object[] objArr) {
        if (objArr == null) {
            return "[]";
        }
        StringBuilder sbB = v.e.b("[");
        for (Object obj : objArr) {
            String strA = obj instanceof Bundle ? a((Bundle) obj) : String.valueOf(obj);
            if (strA != null) {
                if (sbB.length() != 1) {
                    sbB.append(", ");
                }
                sbB.append(strA);
            }
        }
        sbB.append("]");
        return sbB.toString();
    }

    public final String f(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7300a.b() ? str : c(str, c2.f7116h, c2.f7115g, f7298c);
    }

    public final String g(String str) {
        if (str == null) {
            return null;
        }
        return !this.f7300a.b() ? str : str.startsWith("_exp_") ? e6.j.n("experiment_id(", str, ")") : c(str, c2.f, c2.f7114e, f7299d);
    }
}
