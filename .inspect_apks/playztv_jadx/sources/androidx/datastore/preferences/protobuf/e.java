package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a5;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements Iterator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1037u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1038v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f1039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f1040x;

    public e(a5 a5Var) {
        this.f1040x = a5Var;
        this.f1039w = a5Var.h();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f1037u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f1038v < this.f1039w) {
                }
                break;
            default:
                if (this.f1038v < this.f1039w) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f1037u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f1038v;
                if (i >= this.f1039w) {
                    throw new NoSuchElementException();
                }
                this.f1038v = i + 1;
                return Byte.valueOf(((g) this.f1040x).f1046v[i]);
            default:
                int i10 = this.f1038v;
                if (i10 >= this.f1039w) {
                    throw new NoSuchElementException();
                }
                this.f1038v = i10 + 1;
                return Byte.valueOf(((a5) this.f1040x).f(i10));
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f1037u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public e(g gVar) {
        this.f1040x = gVar;
        this.f1039w = gVar.size();
    }
}
