package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d0 extends b implements e0, RandomAccess {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f1030v;

    static {
        new d0(10).f1011u = false;
    }

    public d0(int i) {
        this(new ArrayList(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i, Object obj) {
        b();
        this.f1030v.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f1030v.size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        b();
        this.f1030v.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        ArrayList arrayList = this.f1030v;
        Object obj = arrayList.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof g)) {
            byte[] bArr = (byte[]) obj;
            String str = new String(bArr, z.f1147a);
            if (v1.f1143a.i(bArr, 0, bArr.length) == 0) {
                arrayList.set(i, str);
            }
            return str;
        }
        g gVar = (g) obj;
        String str2 = gVar.size() == 0 ? "" : new String(gVar.f1046v, gVar.d(), gVar.size(), z.f1147a);
        int iD = gVar.d();
        if (v1.f1143a.i(gVar.f1046v, iD, gVar.size() + iD) == 0) {
            arrayList.set(i, str2);
        }
        return str2;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    public final y k(int i) {
        ArrayList arrayList = this.f1030v;
        if (i < arrayList.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList2 = new ArrayList(i);
        arrayList2.addAll(arrayList);
        return new d0(arrayList2);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final void m(g gVar) {
        b();
        this.f1030v.add(gVar);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final e0 o() {
        return this.f1011u ? new n1(this) : this;
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final Object p(int i) {
        return this.f1030v.get(i);
    }

    @Override // androidx.datastore.preferences.protobuf.e0
    public final List q() {
        return Collections.unmodifiableList(this.f1030v);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i) {
        b();
        Object objRemove = this.f1030v.remove(i);
        ((AbstractList) this).modCount++;
        if (objRemove instanceof String) {
            return (String) objRemove;
        }
        if (!(objRemove instanceof g)) {
            return new String((byte[]) objRemove, z.f1147a);
        }
        g gVar = (g) objRemove;
        return gVar.size() == 0 ? "" : new String(gVar.f1046v, gVar.d(), gVar.size(), z.f1147a);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i, Object obj) {
        b();
        Object obj2 = this.f1030v.set(i, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof g)) {
            return new String((byte[]) obj2, z.f1147a);
        }
        g gVar = (g) obj2;
        return gVar.size() == 0 ? "" : new String(gVar.f1046v, gVar.d(), gVar.size(), z.f1147a);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f1030v.size();
    }

    public d0(ArrayList arrayList) {
        this.f1030v = arrayList;
    }

    @Override // androidx.datastore.preferences.protobuf.b, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection collection) {
        b();
        if (collection instanceof e0) {
            collection = ((e0) collection).q();
        }
        boolean zAddAll = this.f1030v.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }
}
