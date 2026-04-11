package p1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a1 extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9641e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9643c;

    static {
        int i = s1.b0.f11647a;
        f9640d = Integer.toString(1, 36);
        f9641e = Integer.toString(2, 36);
    }

    public a1() {
        this.f9642b = false;
        this.f9643c = false;
    }

    @Override // p1.x0
    public final boolean b() {
        return this.f9642b;
    }

    @Override // p1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f10107a, 3);
        bundle.putBoolean(f9640d, this.f9642b);
        bundle.putBoolean(f9641e, this.f9643c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a1)) {
            return false;
        }
        a1 a1Var = (a1) obj;
        return this.f9643c == a1Var.f9643c && this.f9642b == a1Var.f9642b;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f9642b), Boolean.valueOf(this.f9643c));
    }

    public a1(boolean z2) {
        this.f9642b = true;
        this.f9643c = z2;
    }
}
