package g4;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f5149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f5150e;
    public static final String f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f5153c;

    static {
        int i = s1.b0.f11647a;
        f5149d = Integer.toString(0, 36);
        f5150e = Integer.toString(1, 36);
        f = Integer.toString(2, 36);
    }

    public o1(int i) {
        this(i, "no error message provided", Bundle.EMPTY);
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putInt(f5149d, this.f5151a);
        bundle.putString(f5150e, this.f5152b);
        Bundle bundle2 = this.f5153c;
        if (!bundle2.isEmpty()) {
            bundle.putBundle(f, bundle2);
        }
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o1)) {
            return false;
        }
        o1 o1Var = (o1) obj;
        return this.f5151a == o1Var.f5151a && Objects.equals(this.f5152b, o1Var.f5152b);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f5151a), this.f5152b);
    }

    public o1(int i, String str, Bundle bundle) {
        boolean z2 = true;
        if (i >= 0 && i != 1) {
            z2 = false;
        }
        s1.d.b(z2);
        this.f5151a = i;
        this.f5152b = str;
        this.f5153c = bundle;
    }
}
