package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f3167u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3168v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f3169w;

    public /* synthetic */ r(int i, Object obj) {
        this.f3167u = i;
        this.f3169w = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f3167u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f3168v < ((p) this.f3169w).f3145u.length()) {
                }
                break;
            case 1:
                if (this.f3168v < ((p) this.f3169w).f3145u.length()) {
                }
                break;
            default:
                if (this.f3168v < ((e) this.f3169w).t()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        switch (this.f3167u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f3168v;
                p pVar = (p) this.f3169w;
                if (i >= pVar.f3145u.length()) {
                    throw new NoSuchElementException();
                }
                String str = pVar.f3145u;
                int i10 = this.f3168v;
                this.f3168v = i10 + 1;
                return new p(String.valueOf(str.charAt(i10)));
            case 1:
                if (this.f3168v >= ((p) this.f3169w).f3145u.length()) {
                    throw new NoSuchElementException();
                }
                int i11 = this.f3168v;
                this.f3168v = i11 + 1;
                return new p(String.valueOf(i11));
            default:
                int i12 = this.f3168v;
                e eVar = (e) this.f3169w;
                if (i12 >= eVar.t()) {
                    throw new NoSuchElementException(e6.j.l("Out of bounds index: ", this.f3168v));
                }
                int i13 = this.f3168v;
                this.f3168v = i13 + 1;
                return eVar.r(i13);
        }
    }
}
