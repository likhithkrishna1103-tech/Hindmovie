package b2;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends c {
    public Uri A;
    public AssetFileDescriptor B;
    public FileInputStream C;
    public long D;
    public boolean E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ContentResolver f1681z;

    public e(Context context) {
        super(false);
        this.f1681z = context.getContentResolver();
    }

    @Override // b2.h
    public final long B(o oVar) throws d {
        int i;
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor;
        try {
            try {
                Uri uri = oVar.f1714a;
                long j4 = oVar.f1719g;
                long j7 = oVar.f;
                Uri uriNormalizeScheme = uri.normalizeScheme();
                this.A = uriNormalizeScheme;
                e();
                boolean zEquals = Objects.equals(uriNormalizeScheme.getScheme(), "content");
                ContentResolver contentResolver = this.f1681z;
                if (zEquals) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uriNormalizeScheme, "*/*", bundle);
                } else {
                    assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uriNormalizeScheme, "r");
                }
                this.B = assetFileDescriptorOpenAssetFileDescriptor;
                if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                    i = 2000;
                    try {
                        throw new d(new IOException("Could not open file descriptor for: " + uriNormalizeScheme), 2000);
                    } catch (IOException e9) {
                        e = e9;
                        if (e instanceof FileNotFoundException) {
                            i = 2005;
                        }
                        throw new d(e, i);
                    }
                }
                long length = assetFileDescriptorOpenAssetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptorOpenAssetFileDescriptor.getFileDescriptor());
                this.C = fileInputStream;
                if (length != -1 && j7 > length) {
                    throw new d(null, 2008);
                }
                long startOffset = assetFileDescriptorOpenAssetFileDescriptor.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j7) - startOffset;
                if (jSkip != j7) {
                    throw new d(null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    long size = channel.size();
                    if (size == 0) {
                        this.D = -1L;
                    } else {
                        long jPosition = size - channel.position();
                        this.D = jPosition;
                        if (jPosition < 0) {
                            throw new d(null, 2008);
                        }
                    }
                } else {
                    long j10 = length - jSkip;
                    this.D = j10;
                    if (j10 < 0) {
                        throw new d(null, 2008);
                    }
                }
                if (j4 != -1) {
                    long j11 = this.D;
                    this.D = j11 == -1 ? j4 : Math.min(j11, j4);
                }
                this.E = true;
                f(oVar);
                return j4 != -1 ? j4 : this.D;
            } catch (IOException e10) {
                e = e10;
                i = 2000;
            }
        } catch (d e11) {
            throw e11;
        }
    }

    @Override // b2.h
    public final void close() {
        this.A = null;
        try {
            try {
                FileInputStream fileInputStream = this.C;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.C = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.B;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e9) {
                        throw new d(e9, 2000);
                    }
                } finally {
                    this.B = null;
                    if (this.E) {
                        this.E = false;
                        c();
                    }
                }
            } catch (IOException e10) {
                throw new d(e10, 2000);
            }
        } catch (Throwable th) {
            this.C = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.B;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.B = null;
                    if (this.E) {
                        this.E = false;
                        c();
                    }
                    throw th;
                } catch (IOException e11) {
                    throw new d(e11, 2000);
                }
            } finally {
                this.B = null;
                if (this.E) {
                    this.E = false;
                    c();
                }
            }
        }
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws d {
        if (i10 == 0) {
            return 0;
        }
        long j4 = this.D;
        if (j4 != 0) {
            if (j4 != -1) {
                try {
                    i10 = (int) Math.min(j4, i10);
                } catch (IOException e9) {
                    throw new d(e9, 2000);
                }
            }
            FileInputStream fileInputStream = this.C;
            int i11 = y1.a0.f14551a;
            int i12 = fileInputStream.read(bArr, i, i10);
            if (i12 != -1) {
                long j7 = this.D;
                if (j7 != -1) {
                    this.D = j7 - ((long) i12);
                }
                b(i12);
                return i12;
            }
        }
        return -1;
    }

    @Override // b2.h
    public final Uri t() {
        return this.A;
    }
}
