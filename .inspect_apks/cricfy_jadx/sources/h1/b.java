package h1;

import ge.i;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import sd.j;
import sd.l;
import sd.s;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p6.d f5474b;

    public b(LinkedHashMap linkedHashMap, boolean z10) {
        this.f5473a = linkedHashMap;
        this.f5474b = new p6.d(z10);
    }

    public final Map a() {
        rd.f fVar;
        Set<Map.Entry> setEntrySet = this.f5473a.entrySet();
        int iA = s.A(l.f0(setEntrySet, 10));
        if (iA < 16) {
            iA = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iA);
        for (Map.Entry entry : setEntrySet) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                Object key = entry.getKey();
                byte[] bArr = (byte[]) value;
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                i.d(bArrCopyOf, "copyOf(this, size)");
                fVar = new rd.f(key, bArrCopyOf);
            } else {
                fVar = new rd.f(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(fVar.f10993v, fVar.f10994w);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        i.d(mapUnmodifiableMap, "unmodifiableMap(map)");
        return mapUnmodifiableMap;
    }

    public final void b() {
        if (((AtomicBoolean) this.f5474b.f10037w).get()) {
            throw new IllegalStateException("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void c(e eVar) {
        i.e(eVar, "key");
        b();
        this.f5473a.remove(eVar);
    }

    public final void d(e eVar, Object obj) {
        i.e(eVar, "key");
        e(eVar, obj);
    }

    public final void e(e eVar, Object obj) {
        i.e(eVar, "key");
        b();
        if (obj == null) {
            c(eVar);
            return;
        }
        boolean z10 = obj instanceof Set;
        LinkedHashMap linkedHashMap = this.f5473a;
        if (z10) {
            Set setUnmodifiableSet = Collections.unmodifiableSet(j.u0((Set) obj));
            i.d(setUnmodifiableSet, "unmodifiableSet(set.toSet())");
            linkedHashMap.put(eVar, setUnmodifiableSet);
        } else {
            if (!(obj instanceof byte[])) {
                linkedHashMap.put(eVar, obj);
                return;
            }
            byte[] bArr = (byte[]) obj;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            i.d(bArrCopyOf, "copyOf(this, size)");
            linkedHashMap.put(eVar, bArrCopyOf);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof h1.b
            r1 = 0
            if (r0 != 0) goto L6
            goto L60
        L6:
            h1.b r7 = (h1.b) r7
            java.util.LinkedHashMap r7 = r7.f5473a
            java.util.LinkedHashMap r0 = r6.f5473a
            r2 = 1
            if (r7 != r0) goto L10
            goto L61
        L10:
            int r3 = r7.size()
            int r4 = r0.size()
            if (r3 == r4) goto L1b
            goto L60
        L1b:
            boolean r3 = r7.isEmpty()
            if (r3 == 0) goto L22
            goto L61
        L22:
            java.util.Set r7 = r7.entrySet()
            java.util.Iterator r7 = r7.iterator()
        L2a:
            boolean r3 = r7.hasNext()
            if (r3 == 0) goto L61
            java.lang.Object r3 = r7.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.Object r4 = r0.get(r4)
            if (r4 == 0) goto L5d
            java.lang.Object r3 = r3.getValue()
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L58
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L5d
            byte[] r3 = (byte[]) r3
            byte[] r4 = (byte[]) r4
            boolean r3 = java.util.Arrays.equals(r3, r4)
            if (r3 == 0) goto L5d
            r3 = r2
            goto L5e
        L58:
            boolean r3 = ge.i.a(r3, r4)
            goto L5e
        L5d:
            r3 = r1
        L5e:
            if (r3 != 0) goto L2a
        L60:
            return r1
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        Iterator it = this.f5473a.entrySet().iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            iHashCode += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return iHashCode;
    }

    public final String toString() {
        return j.l0(this.f5473a.entrySet(), ",\n", "{\n", "\n}", a.f5472w, 24);
    }

    public /* synthetic */ b(boolean z10) {
        this(new LinkedHashMap(), z10);
    }
}
