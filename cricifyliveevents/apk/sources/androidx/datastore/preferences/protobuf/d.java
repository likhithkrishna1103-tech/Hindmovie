package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.a5;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f690v = 0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f691w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f692x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ Object f693y;

    public d(a5 a5Var) {
        this.f693y = a5Var;
        this.f692x = a5Var.c();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f690v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f691w < this.f692x) {
                }
                break;
            default:
                if (this.f691w < this.f692x) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f690v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f691w;
                if (i >= this.f692x) {
                    throw new NoSuchElementException();
                }
                this.f691w = i + 1;
                return Byte.valueOf(((g) this.f693y).g(i));
            default:
                int i10 = this.f691w;
                if (i10 >= this.f692x) {
                    throw new NoSuchElementException();
                }
                this.f691w = i10 + 1;
                return Byte.valueOf(((a5) this.f693y).b(i10));
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f690v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public d(g gVar) {
        this.f693y = gVar;
        this.f692x = gVar.size();
    }
}
