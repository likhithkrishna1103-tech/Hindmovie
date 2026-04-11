package y1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Iterable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f14577v = new Object();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f14578w = new HashMap();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Set f14579x = Collections.EMPTY_SET;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List f14580y = Collections.EMPTY_LIST;

    public final int a(l2.k kVar) {
        int iIntValue;
        synchronized (this.f14577v) {
            try {
                iIntValue = this.f14578w.containsKey(kVar) ? ((Integer) this.f14578w.get(kVar)).intValue() : 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        return iIntValue;
    }

    public final void b(l2.k kVar) {
        synchronized (this.f14577v) {
            try {
                Integer num = (Integer) this.f14578w.get(kVar);
                if (num == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.f14580y);
                arrayList.remove(kVar);
                this.f14580y = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.f14578w.remove(kVar);
                    HashSet hashSet = new HashSet(this.f14579x);
                    hashSet.remove(kVar);
                    this.f14579x = Collections.unmodifiableSet(hashSet);
                } else {
                    this.f14578w.put(kVar, Integer.valueOf(num.intValue() - 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterator it;
        synchronized (this.f14577v) {
            it = this.f14580y.iterator();
        }
        return it;
    }
}
