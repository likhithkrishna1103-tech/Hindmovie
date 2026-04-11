package ge;

import android.view.View;
import android.view.ViewGroup;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class b implements Iterator, he.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f5238v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f5239w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f5240x;

    public /* synthetic */ b(int i, Object obj) {
        this.f5238v = i;
        this.f5240x = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5238v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return this.f5239w < ((Object[]) this.f5240x).length;
            case 1:
                Iterator it = (Iterator) this.f5240x;
                while (this.f5239w > 0 && it.hasNext()) {
                    it.next();
                    this.f5239w--;
                }
                return it.hasNext();
            case 2:
                return this.f5239w < ((sd.d) this.f5240x).a();
            default:
                return this.f5239w < ((ViewGroup) this.f5240x).getChildCount();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5238v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                try {
                    Object[] objArr = (Object[]) this.f5240x;
                    int i = this.f5239w;
                    this.f5239w = i + 1;
                    return objArr[i];
                } catch (ArrayIndexOutOfBoundsException e9) {
                    this.f5239w--;
                    throw new NoSuchElementException(e9.getMessage());
                }
            case 1:
                Iterator it = (Iterator) this.f5240x;
                while (this.f5239w > 0 && it.hasNext()) {
                    it.next();
                    this.f5239w--;
                }
                return it.next();
            case 2:
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                sd.d dVar = (sd.d) this.f5240x;
                int i10 = this.f5239w;
                this.f5239w = i10 + 1;
                return dVar.get(i10);
            default:
                ViewGroup viewGroup = (ViewGroup) this.f5240x;
                int i11 = this.f5239w;
                this.f5239w = i11 + 1;
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null) {
                    return childAt;
                }
                throw new IndexOutOfBoundsException();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f5238v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                ViewGroup viewGroup = (ViewGroup) this.f5240x;
                int i = this.f5239w - 1;
                this.f5239w = i;
                viewGroup.removeViewAt(i);
                return;
        }
    }

    public b(Object[] objArr) {
        this.f5238v = 0;
        i.e(objArr, "array");
        this.f5240x = objArr;
    }

    public b(me.b bVar) {
        this.f5238v = 1;
        this.f5240x = bVar.f8454a.iterator();
        this.f5239w = bVar.f8455b;
    }
}
