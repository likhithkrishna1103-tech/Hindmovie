package q;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class f implements Iterable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f10317v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f10318w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final WeakHashMap f10319x = new WeakHashMap();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f10320y = 0;

    public c a(Object obj) {
        c cVar = this.f10317v;
        while (cVar != null && !cVar.f10310v.equals(obj)) {
            cVar = cVar.f10312x;
        }
        return cVar;
    }

    public Object b(Object obj) {
        c cVarA = a(obj);
        if (cVarA == null) {
            return null;
        }
        this.f10320y--;
        WeakHashMap weakHashMap = this.f10319x;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(cVarA);
            }
        }
        c cVar = cVarA.f10313y;
        if (cVar != null) {
            cVar.f10312x = cVarA.f10312x;
        } else {
            this.f10317v = cVarA.f10312x;
        }
        c cVar2 = cVarA.f10312x;
        if (cVar2 != null) {
            cVar2.f10313y = cVar;
        } else {
            this.f10318w = cVar;
        }
        cVarA.f10312x = null;
        cVarA.f10313y = null;
        return cVarA.f10311w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((q.b) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof q.f
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            q.f r7 = (q.f) r7
            int r1 = r6.f10320y
            int r3 = r7.f10320y
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            q.b r3 = (q.b) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            q.b r4 = (q.b) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            q.b r7 = (q.b) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            return r0
        L53:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: q.f.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) bVar.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        b bVar = new b(this.f10317v, this.f10318w, 0);
        this.f10319x.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) bVar.next()).toString());
            if (bVar.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
