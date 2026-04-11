package p1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends x0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f10052d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f10053e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f10054b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10055c;

    static {
        int i = s1.b0.f11647a;
        f10052d = Integer.toString(1, 36);
        f10053e = Integer.toString(2, 36);
    }

    public s() {
        this.f10054b = false;
        this.f10055c = false;
    }

    @Override // p1.x0
    public final boolean b() {
        return this.f10054b;
    }

    @Override // p1.x0
    public final Bundle c() {
        Bundle bundle = new Bundle();
        bundle.putInt(x0.f10107a, 0);
        bundle.putBoolean(f10052d, this.f10054b);
        bundle.putBoolean(f10053e, this.f10055c);
        return bundle;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f10055c == sVar.f10055c && this.f10054b == sVar.f10054b;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.f10054b), Boolean.valueOf(this.f10055c));
    }

    public s(boolean z2) {
        this.f10054b = true;
        this.f10055c = z2;
    }
}
