package v1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    public AssetFileDescriptor A;
    public FileInputStream B;
    public long C;
    public boolean D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ContentResolver f13133y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Uri f13134z;

    public e(Context context) {
        super(false);
        this.f13133y = context.getContentResolver();
    }

    @Override // v1.h
    public final void close() {
        this.f13134z = null;
        try {
            try {
                FileInputStream fileInputStream = this.B;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.B = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.A;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e10) {
                        throw new d(e10, 2000);
                    }
                } finally {
                    this.A = null;
                    if (this.D) {
                        this.D = false;
                        c();
                    }
                }
            } catch (IOException e11) {
                throw new d(e11, 2000);
            }
        } catch (Throwable th) {
            this.B = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.A;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.A = null;
                    if (this.D) {
                        this.D = false;
                        c();
                    }
                    throw th;
                } catch (IOException e12) {
                    throw new d(e12, 2000);
                }
            } finally {
                this.A = null;
                if (this.D) {
                    this.D = false;
                    c();
                }
            }
        }
    }

    @Override // v1.h
    public final long h(m mVar) throws d {
        int i;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            try {
                Uri uri = mVar.f13157a;
                long j5 = mVar.f13162g;
                long j8 = mVar.f;
                Uri uriNormalizeScheme = uri.normalizeScheme();
                this.f13134z = uriNormalizeScheme;
                d();
                boolean zEquals = Objects.equals(uriNormalizeScheme.getScheme(), "content");
                ContentResolver contentResolver = this.f13133y;
                if (zEquals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.A = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    i = 2000;
                    try {
                        throw new d(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), 2000);
                    } catch (IOException e10) {
                        e = e10;
                        if (e instanceof FileNotFoundException) {
                            i = 2005;
                        }
                        throw new d(e, i);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.B = fileInputStream;
                if (length != -1 && j8 > length) {
                    throw new d(null, 2008);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j8) - startOffset;
                if (jSkip != j8) {
                    throw new d(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.C = -1L;
                    } else {
                        long jPosition = size - channel.position();
                        this.C = jPosition;
                        if (jPosition < 0) {
                            throw new d(null, 2008);
                        }
                    }
                } else {
                    long j10 = length - jSkip;
                    this.C = j10;
                    if (j10 < 0) {
                        throw new d(null, 2008);
                    }
                }
                if (j5 != -1) {
                    long j11 = this.C;
                    this.C = j11 == -1 ? j5 : Math.min(j11, j5);
                }
                this.D = true;
                e(mVar);
                return j5 != -1 ? j5 : this.C;
            } catch (IOException e11) {
                e = e11;
                i = 2000;
            }
        } catch (d e12) {
            throw e12;
        }
    }

    @Override // v1.h
    public final Uri o() {
        return this.f13134z;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws d {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.C;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e10) {
                    throw new d(e10, 2000);
                }
            }
            FileInputStream fileInputStream = this.B;
            int i11 = s1.b0.f11647a;
            int i12 = fileInputStream.read(bArr, i, i10);
            if (i12 != -1) {
                long j8 = this.C;
                if (j8 != -1) {
                    this.C = j8 - ((long) i12);
                }
                b(i12);
                return i12;
            }
        }
        return -1;
    }
}
