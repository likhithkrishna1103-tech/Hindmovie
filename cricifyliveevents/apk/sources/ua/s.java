package ua;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s extends AbstractSet {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f12387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ u f12388w;

    public /* synthetic */ s(u uVar, int i) {
        this.f12387v = i;
        this.f12388w = uVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f12387v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f12388w.clear();
                break;
            default:
                this.f12388w.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f12387v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f12388w;
                Map mapB = uVar.b();
                if (mapB != null) {
                    return mapB.entrySet().contains(obj);
                }
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    int iD = uVar.d(entry.getKey());
                    if (iD != -1 && com.bumptech.glide.c.h(uVar.j()[iD], entry.getValue())) {
                        return true;
                    }
                }
                return false;
            default:
                return this.f12388w.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f12387v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f12388w;
                Map mapB = uVar.b();
                return mapB != null ? mapB.entrySet().iterator() : new r(uVar, 1);
            default:
                u uVar2 = this.f12388w;
                Map mapB2 = uVar2.b();
                return mapB2 != null ? mapB2.keySet().iterator() : new r(uVar2, 0);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f12387v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                u uVar = this.f12388w;
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
                        Object obj2 = uVar.f12394v;
                        Objects.requireNonNull(obj2);
                        int iQ = q.q(key, value, iC, obj2, uVar.h(), uVar.i(), uVar.j());
                        if (iQ != -1) {
                            uVar.e(iQ, iC);
                            uVar.A--;
                            uVar.f12398z += 32;
                            return true;
                        }
                    }
                }
                return false;
            default:
                u uVar2 = this.f12388w;
                Map mapB2 = uVar2.b();
                return mapB2 != null ? mapB2.keySet().remove(obj) : uVar2.g(obj) != u.E;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f12387v) {
        }
        return this.f12388w.size();
    }
}
