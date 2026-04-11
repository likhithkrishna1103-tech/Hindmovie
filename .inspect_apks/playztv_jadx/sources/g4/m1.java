package g4;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final aa.c1 f5130d = aa.j0.v(40010);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final aa.c1 f5131e;
    public static final String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f5132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f5133h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f5136c;

    static {
        Object[] objArr = {50000, 50001, 50002, 50003, 50004, 50005, 50006};
        aa.q.b(7, objArr);
        f5131e = aa.j0.l(7, objArr);
        int i = s1.b0.f11647a;
        f = Integer.toString(0, 36);
        f5132g = Integer.toString(1, 36);
        f5133h = Integer.toString(2, 36);
    }

    public m1(int i) {
        s1.d.a("commandCode shouldn't be COMMAND_CODE_CUSTOM", i != 0);
        this.f5134a = i;
        this.f5135b = "";
        this.f5136c = Bundle.EMPTY;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return this.f5134a == m1Var.f5134a && TextUtils.equals(this.f5135b, m1Var.f5135b);
    }

    public final int hashCode() {
        return Objects.hash(this.f5135b, Integer.valueOf(this.f5134a));
    }

    public m1(String str, Bundle bundle) {
        this.f5134a = 0;
        this.f5135b = str;
        bundle.getClass();
        this.f5136c = new Bundle(bundle);
    }
}
