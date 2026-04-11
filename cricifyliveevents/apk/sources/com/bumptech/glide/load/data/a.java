package com.bumptech.glide.load.data;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends m {

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final /* synthetic */ int f2228z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(ContentResolver contentResolver, Uri uri, boolean z10, int i) {
        super(contentResolver, uri, z10);
        this.f2228z = i;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        switch (this.f2228z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return AssetFileDescriptor.class;
            default:
                return ParcelFileDescriptor.class;
        }
    }

    @Override // com.bumptech.glide.load.data.m
    public final void c(Object obj) throws IOException {
        switch (this.f2228z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((AssetFileDescriptor) obj).close();
                break;
            default:
                ((ParcelFileDescriptor) obj).close();
                break;
        }
    }

    @Override // com.bumptech.glide.load.data.m
    public final Object d(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        switch (this.f2228z) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                boolean z10 = this.f2251v;
                ContentResolver contentResolver2 = this.f2253x;
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = (!z10 || !t1.j(uri) || Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) < 17) ? contentResolver2.openAssetFileDescriptor(uri, "r") : MediaStore.openAssetFileDescriptor(contentResolver2, uri, "r", null);
                if (assetFileDescriptorOpenAssetFileDescriptor != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor;
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
            default:
                boolean z11 = this.f2251v;
                ContentResolver contentResolver3 = this.f2253x;
                AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor2 = (!z11 || !t1.j(uri) || Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) < 17) ? contentResolver3.openAssetFileDescriptor(uri, "r") : MediaStore.openAssetFileDescriptor(contentResolver3, uri, "r", null);
                if (assetFileDescriptorOpenAssetFileDescriptor2 != null) {
                    return assetFileDescriptorOpenAssetFileDescriptor2.getParcelFileDescriptor();
                }
                throw new FileNotFoundException("FileDescriptor is null for: " + uri);
        }
    }
}
