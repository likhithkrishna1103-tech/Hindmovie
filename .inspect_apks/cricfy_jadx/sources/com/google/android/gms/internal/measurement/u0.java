package com.google.android.gms.internal.measurement;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2647a;

    public /* synthetic */ u0(int i) {
        this.f2647a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int iO = n5.a.O(parcel);
                Bundle bundleG = null;
                String strJ = null;
                boolean zE = false;
                long jG = 0;
                long jG2 = 0;
                while (parcel.dataPosition() < iO) {
                    int i = parcel.readInt();
                    char c9 = (char) i;
                    if (c9 == 1) {
                        jG = n5.a.G(parcel, i);
                    } else if (c9 == 2) {
                        jG2 = n5.a.G(parcel, i);
                    } else if (c9 == 3) {
                        zE = n5.a.E(parcel, i);
                    } else if (c9 == 7) {
                        bundleG = n5.a.g(parcel, i);
                    } else if (c9 != '\b') {
                        n5.a.K(parcel, i);
                    } else {
                        strJ = n5.a.j(parcel, i);
                    }
                }
                n5.a.m(parcel, iO);
                return new t0(jG, jG2, zE, bundleG, strJ);
            default:
                int iO2 = n5.a.O(parcel);
                String strJ2 = null;
                int iF = 0;
                Intent intent = null;
                while (parcel.dataPosition() < iO2) {
                    int i10 = parcel.readInt();
                    char c10 = (char) i10;
                    if (c10 == 1) {
                        iF = n5.a.F(parcel, i10);
                    } else if (c10 == 2) {
                        strJ2 = n5.a.j(parcel, i10);
                    } else if (c10 != 3) {
                        n5.a.K(parcel, i10);
                    } else {
                        intent = (Intent) n5.a.i(parcel, i10, Intent.CREATOR);
                    }
                }
                n5.a.m(parcel, iO2);
                return new v0(iF, strJ2, intent);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f2647a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new t0[i];
            default:
                return new v0[i];
        }
    }
}
