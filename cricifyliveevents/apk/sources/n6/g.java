package n6;

import g6.w;
import g6.x;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f8804b;

    public g(String str, boolean z10, int i) {
        this.f8803a = i;
        this.f8804b = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        if (((HashSet) wVar.G.f10035w).contains(x.f5157v)) {
            return new i6.m(this);
        }
        s6.c.b("Animation contains merge paths but they are disabled.");
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MergePaths{mode=");
        int i = this.f8803a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "null" : "EXCLUDE_INTERSECTIONS" : "INTERSECT" : "SUBTRACT" : "ADD" : "MERGE");
        sb.append('}');
        return sb.toString();
    }
}
