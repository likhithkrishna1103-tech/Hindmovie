package z6;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Iterable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f15304v;

    public q(ArrayList arrayList) {
        this.f15304v = arrayList;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f15304v.iterator();
    }
}
