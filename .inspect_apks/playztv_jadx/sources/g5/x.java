package g5;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f5315b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5314a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f5316c = new ArrayList();

    public x(View view) {
        this.f5315b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f5315b == xVar.f5315b && this.f5314a.equals(xVar.f5314a);
    }

    public final int hashCode() {
        return this.f5314a.hashCode() + (this.f5315b.hashCode() * 31);
    }

    public final String toString() {
        String strM = e6.j.m(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f5315b + "\n", "    values:");
        HashMap map = this.f5314a;
        for (String str : map.keySet()) {
            strM = strM + "    " + str + ": " + map.get(str) + "\n";
        }
        return strM;
    }
}
