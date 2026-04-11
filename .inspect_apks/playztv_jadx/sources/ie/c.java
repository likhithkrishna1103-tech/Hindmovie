package ie;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final CharSequence f6607u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f6608v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f6609w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f6610x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f6611y;

    public c(CharSequence charSequence) {
        be.h.e(charSequence, "string");
        this.f6607u = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i10;
        int i11 = this.f6608v;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f6611y < 0) {
            this.f6608v = 2;
            return false;
        }
        CharSequence charSequence = this.f6607u;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i12 = this.f6609w; i12 < length2; i12++) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i10 = i12 + 1) < charSequence.length() && charSequence.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f6608v = 1;
                this.f6611y = i;
                this.f6610x = length;
                return true;
            }
        }
        i = -1;
        this.f6608v = 1;
        this.f6611y = i;
        this.f6610x = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6608v = 0;
        int i = this.f6610x;
        int i10 = this.f6609w;
        this.f6609w = this.f6611y + i;
        return this.f6607u.subSequence(i10, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
