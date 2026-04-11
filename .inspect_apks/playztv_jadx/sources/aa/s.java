package aa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s extends AbstractSet {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f740u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f741v;

    public /* synthetic */ s(u uVar, int i) {
        this.f740u = i;
        this.f741v = uVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f740u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f741v.clear();
                break;
            default:
                this.f741v.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f740u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f741v;
                Map mapB = uVar.b();
                if (mapB != null) {
                    return mapB.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iD = uVar.d(entry.getKey());
                    if (iD != -1 && i5.a.o(uVar.j()[iD], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.f741v.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f740u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f741v;
                Map mapB = uVar.b();
                return mapB != null ? mapB.entrySet().iterator() : new r(uVar, 1);
            default:
                u uVar2 = this.f741v;
                Map mapB2 = uVar2.b();
                return mapB2 != null ? mapB2.keySet().iterator() : new r(uVar2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f740u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f741v;
                Map mapB = uVar.b();
                if (mapB != null) {
                    return mapB.entrySet().remove(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (!uVar.f()) {
                        int iC = uVar.c();
                        Object key = entry.getKey();
                        Object value = entry.getValue();
                        Object obj2 = uVar.f749u;
                        Objects.requireNonNull(obj2);
                        int iP = q.p(key, value, iC, obj2, uVar.h(), uVar.i(), uVar.j());
                        if (iP != -1) {
                            uVar.e(iP, iC);
                            uVar.f754z--;
                            uVar.f753y += 32;
                            return true;
                        }
                    }
                }
                return false;
            default:
                u uVar2 = this.f741v;
                Map mapB2 = uVar2.b();
                return mapB2 != null ? mapB2.keySet().remove(obj) : uVar2.g(obj) != u.D;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f740u) {
        }
        return this.f741v.size();
    }
}
