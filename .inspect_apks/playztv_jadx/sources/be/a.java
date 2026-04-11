package be;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class a implements Iterator, ce.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2028u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2029v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f2030w;

    public /* synthetic */ a(int i, Object obj) {
        this.f2028u = i;
        this.f2030w = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2028u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f2029v < ((Object[]) this.f2030w).length;
            case 1:
                Iterator it = (Iterator) this.f2030w;
                while (this.f2029v > 0 && it.hasNext()) {
                    it.next();
                    this.f2029v--;
                }
                return it.hasNext();
            case 2:
                return this.f2029v < ((od.c) this.f2030w).b();
            default:
                return this.f2029v < ((ViewGroup) this.f2030w).getChildCount();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f2028u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Object[] objArr = (Object[]) this.f2030w;
                    int i = this.f2029v;
                    this.f2029v = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e10) {
                    this.f2029v--;
                    throw new NoSuchElementException(e10.getMessage());
                }
            case 1:
                Iterator it = (Iterator) this.f2030w;
                while (this.f2029v > 0 && it.hasNext()) {
                    it.next();
                    this.f2029v--;
                }
                return it.next();
            case 2:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                od.c cVar = (od.c) this.f2030w;
                int i10 = this.f2029v;
                this.f2029v = i10 + 1;
                return cVar.get(i10);
            default:
                ViewGroup viewGroup = (ViewGroup) this.f2030w;
                int i11 = this.f2029v;
                this.f2029v = i11 + 1;
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f2028u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ViewGroup viewGroup = (ViewGroup) this.f2030w;
                int i = this.f2029v - 1;
                this.f2029v = i;
                viewGroup.removeViewAt(i);
                return;
        }
    }

    public a(Object[] objArr) {
        this.f2028u = 0;
        h.e(objArr, "array");
        this.f2030w = objArr;
    }

    public a(he.b bVar) {
        this.f2028u = 1;
        this.f2030w = bVar.f6077a.iterator();
        this.f2029v = bVar.f6078b;
    }
}
