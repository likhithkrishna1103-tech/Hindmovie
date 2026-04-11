package ta;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Iterator {
    public int A;
    public final /* synthetic */ l4.a B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f11962w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CharSequence f11963x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f11964y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f11961v = 2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f11965z = 0;

    public k(l4.a aVar, f3.a aVar2, CharSequence charSequence) {
        this.B = aVar;
        this.f11964y = (b) aVar2.f3936x;
        this.A = aVar2.f3935w;
        this.f11963x = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String string;
        b bVar;
        int i = this.f11961v;
        if (i == 4) {
            throw new IllegalStateException();
        }
        int iC = y.e.c(i);
        if (iC == 0) {
            return true;
        }
        if (iC == 2) {
            return false;
        }
        this.f11961v = 4;
        int i10 = this.f11965z;
        while (true) {
            int length = this.f11965z;
            if (length == -1) {
                this.f11961v = 3;
                string = null;
                break;
            }
            c cVar = (c) this.B.f7697v;
            CharSequence charSequence = this.f11963x;
            int length2 = charSequence.length();
            com.bumptech.glide.d.i(length, length2);
            while (true) {
                if (length >= length2) {
                    length = -1;
                    break;
                }
                if (cVar.a(charSequence.charAt(length))) {
                    break;
                }
                length++;
            }
            if (length == -1) {
                length = charSequence.length();
                this.f11965z = -1;
            } else {
                this.f11965z = length + 1;
            }
            int i11 = this.f11965z;
            if (i11 == i10) {
                int i12 = i11 + 1;
                this.f11965z = i12;
                if (i12 > charSequence.length()) {
                    this.f11965z = -1;
                }
            } else {
                while (true) {
                    bVar = this.f11964y;
                    if (i10 >= length || !bVar.a(charSequence.charAt(i10))) {
                        break;
                    }
                    i10++;
                }
                while (length > i10 && bVar.a(charSequence.charAt(length - 1))) {
                    length--;
                }
                int i13 = this.A;
                if (i13 == 1) {
                    length = charSequence.length();
                    this.f11965z = -1;
                    while (length > i10 && bVar.a(charSequence.charAt(length - 1))) {
                        length--;
                    }
                } else {
                    this.A = i13 - 1;
                }
                string = charSequence.subSequence(i10, length).toString();
            }
        }
        this.f11962w = string;
        if (this.f11961v == 3) {
            return false;
        }
        this.f11961v = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f11961v = 2;
        String str = this.f11962w;
        this.f11962w = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
