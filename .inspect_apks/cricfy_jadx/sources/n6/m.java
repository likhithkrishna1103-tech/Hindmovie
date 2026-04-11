package n6;

import g6.w;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8828a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f8829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f8830c;

    public m(String str, List list, boolean z10) {
        this.f8828a = str;
        this.f8829b = list;
        this.f8830c = z10;
    }

    @Override // n6.b
    public final i6.d a(w wVar, g6.i iVar, o6.a aVar) {
        return new i6.e(wVar, aVar, this, iVar);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f8828a + "' Shapes: " + Arrays.toString(this.f8829b.toArray()) + '}';
    }
}
