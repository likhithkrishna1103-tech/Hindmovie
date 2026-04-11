package com.google.android.gms.internal.measurement;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p implements Iterator {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2566v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2567w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ Object f2568x;

    public /* synthetic */ p(int i, Object obj) {
        this.f2566v = i;
        this.f2568x = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2566v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (this.f2567w < ((q) this.f2568x).f2579v.length()) {
                }
                break;
            case 1:
                if (this.f2567w < ((q) this.f2568x).f2579v.length()) {
                }
                break;
            default:
                if (this.f2567w < ((d) this.f2568x).m()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        switch (this.f2566v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                String str = ((q) this.f2568x).f2579v;
                int i = this.f2567w;
                if (i >= str.length()) {
                    throw new NoSuchElementException();
                }
                this.f2567w = i + 1;
                return new q(String.valueOf(i));
            case 1:
                q qVar = (q) this.f2568x;
                String str2 = qVar.f2579v;
                int i10 = this.f2567w;
                if (i10 >= str2.length()) {
                    throw new NoSuchElementException();
                }
                this.f2567w = i10 + 1;
                return new q(String.valueOf(qVar.f2579v.charAt(i10)));
            default:
                d dVar = (d) this.f2568x;
                if (this.f2567w < dVar.m()) {
                    int i11 = this.f2567w;
                    this.f2567w = i11 + 1;
                    return dVar.n(i11);
                }
                int i12 = this.f2567w;
                StringBuilder sb = new StringBuilder(String.valueOf(i12).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i12);
                throw new NoSuchElementException(sb.toString());
        }
    }
}
