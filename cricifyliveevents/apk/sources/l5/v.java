package l5;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f7830b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f7829a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f7831c = new ArrayList();

    public v(View view) {
        this.f7830b = view;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f7830b == vVar.f7830b && this.f7829a.equals(vVar.f7829a);
    }

    public final int hashCode() {
        return this.f7829a.hashCode() + (this.f7830b.hashCode() * 31);
    }

    public final String toString() {
        String strJ = l0.e.j(("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f7830b + "\n", "    values:");
        HashMap map = this.f7829a;
        for (String str : map.keySet()) {
            strJ = strJ + "    " + str + ": " + map.get(str) + "\n";
        }
        return strJ;
    }
}
