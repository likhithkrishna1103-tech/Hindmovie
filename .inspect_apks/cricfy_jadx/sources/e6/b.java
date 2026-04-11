package e6;

import ge.i;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f3812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList f3813b;

    public b() {
        this.f3812a = new ArrayList();
        this.f3813b = new ArrayList();
    }

    public void a(String str, String str2) {
        i.e(str2, "value");
        this.f3812a.add(zf.a.b(str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, 91));
        this.f3813b.add(zf.a.b(str2, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", false, false, false, false, 91));
    }

    public b(ArrayList arrayList, ArrayList arrayList2) {
        this.f3812a = arrayList;
        this.f3813b = arrayList2;
    }
}
