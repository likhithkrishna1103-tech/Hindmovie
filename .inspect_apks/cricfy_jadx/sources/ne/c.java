package ne;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final CharSequence f9136v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f9137w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f9138x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f9139y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9140z;

    public c(CharSequence charSequence) {
        ge.i.e(charSequence, "string");
        this.f9136v = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i;
        int i10;
        int i11 = this.f9137w;
        if (i11 != 0) {
            return i11 == 1;
        }
        if (this.f9140z < 0) {
            this.f9137w = 2;
            return false;
        }
        CharSequence charSequence = this.f9136v;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i12 = this.f9138x; i12 < length2; i12++) {
            char cCharAt = charSequence.charAt(i12);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i = (cCharAt == '\r' && (i10 = i12 + 1) < charSequence.length() && charSequence.charAt(i10) == '\n') ? 2 : 1;
                length = i12;
                this.f9137w = 1;
                this.f9140z = i;
                this.f9139y = length;
                return true;
            }
        }
        i = -1;
        this.f9137w = 1;
        this.f9140z = i;
        this.f9139y = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9137w = 0;
        int i = this.f9139y;
        int i10 = this.f9138x;
        this.f9138x = this.f9140z + i;
        return this.f9136v.subSequence(i10, i).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
