package androidx.datastore.preferences.protobuf;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.internal.measurement.l6;
import com.google.android.gms.internal.measurement.m6;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f813v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f814w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f815x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Iterator f816y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f817z;

    public /* synthetic */ y0(l6 l6Var) {
        this.f813v = 1;
        Objects.requireNonNull(l6Var);
        this.f817z = l6Var;
        this.f814w = -1;
    }

    public Iterator a() {
        if (this.f816y == null) {
            this.f816y = ((w0) this.f817z).f804w.entrySet().iterator();
        }
        return this.f816y;
    }

    public Iterator b() {
        if (this.f816y == null) {
            this.f816y = ((l6) this.f817z).f2518x.entrySet().iterator();
        }
        return this.f816y;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f813v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = this.f814w + 1;
                w0 w0Var = (w0) this.f817z;
                if (i >= w0Var.f803v.size()) {
                    return !w0Var.f804w.isEmpty() && a().hasNext();
                }
                return true;
            default:
                int i10 = this.f814w + 1;
                l6 l6Var = (l6) this.f817z;
                if (i10 >= l6Var.f2517w) {
                    return !l6Var.f2518x.isEmpty() && b().hasNext();
                }
                return true;
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f813v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f815x = true;
                int i = this.f814w + 1;
                this.f814w = i;
                w0 w0Var = (w0) this.f817z;
                return i < w0Var.f803v.size() ? (Map.Entry) w0Var.f803v.get(this.f814w) : (Map.Entry) a().next();
            default:
                this.f815x = true;
                int i10 = this.f814w + 1;
                this.f814w = i10;
                l6 l6Var = (l6) this.f817z;
                return i10 < l6Var.f2517w ? (m6) l6Var.f2516v[i10] : (Map.Entry) b().next();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.f813v;
        AbstractMap abstractMap = this.f817z;
        switch (i) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                w0 w0Var = (w0) abstractMap;
                if (!this.f815x) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f815x = false;
                int i10 = w0.A;
                w0Var.b();
                if (this.f814w >= w0Var.f803v.size()) {
                    a().remove();
                    return;
                }
                int i11 = this.f814w;
                this.f814w = i11 - 1;
                w0Var.h(i11);
                return;
            default:
                if (!this.f815x) {
                    throw new IllegalStateException("remove() was called before next()");
                }
                this.f815x = false;
                l6 l6Var = (l6) abstractMap;
                l6Var.f();
                int i12 = this.f814w;
                if (i12 >= l6Var.f2517w) {
                    b().remove();
                    return;
                } else {
                    this.f814w = i12 - 1;
                    l6Var.d(i12);
                    return;
                }
        }
    }

    public y0(w0 w0Var) {
        this.f813v = 0;
        this.f817z = w0Var;
        this.f814w = -1;
    }
}
