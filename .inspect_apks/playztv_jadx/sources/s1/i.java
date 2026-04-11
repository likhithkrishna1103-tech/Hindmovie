package s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Iterable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f11671u = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashMap f11672v = new HashMap();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Set f11673w = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f11674x = Collections.EMPTY_LIST;

    public final int b(f2.k kVar) {
        int iIntValue;
        synchronized (this.f11671u) {
            try {
                iIntValue = this.f11672v.containsKey(kVar) ? ((Integer) this.f11672v.get(kVar)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public final void d(f2.k kVar) {
        synchronized (this.f11671u) {
            try {
                Integer num = (Integer) this.f11672v.get(kVar);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f11674x);
                arrayList.remove(kVar);
                this.f11674x = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f11672v.remove(kVar);
                    HashSet hashSet = new HashSet(this.f11673w);
                    hashSet.remove(kVar);
                    this.f11673w = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f11672v.put(kVar, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator it;
        synchronized (this.f11671u) {
            it = this.f11674x.iterator();
        }
        return it;
    }
}
