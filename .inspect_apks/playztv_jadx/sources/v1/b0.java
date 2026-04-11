package v1;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends c {
    public AssetFileDescriptor A;
    public FileInputStream B;
    public long C;
    public boolean D;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Context f13120y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public m f13121z;

    public b0(Context context) {
        super(false);
        this.f13120y = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // v1.h
    public final void close() {
        this.f13121z = null;
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
                        throw new a0(null, e10, 2000);
                    }
                } finally {
                    this.A = null;
                    if (this.D) {
                        this.D = false;
                        c();
                    }
                }
            } catch (IOException e11) {
                throw new a0(null, e11, 2000);
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
                    throw new a0(null, e12, 2000);
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
    public final long h(m mVar) throws a0 {
        Resources resourcesForApplication;
        int identifier;
        int i;
        Resources resources;
        this.f13121z = mVar;
        d();
        Uri uri = mVar.f13157a;
        long j5 = mVar.f13162g;
        long j8 = mVar.f;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        boolean zEquals = TextUtils.equals("rawresource", uriNormalizeScheme.getScheme());
        Context context = this.f13120y;
        if (zEquals) {
            resources = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new a0("rawresource:// URI must have exactly one path element, found " + pathSegments.size(), null, 2000);
            }
            try {
                i = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new a0("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new a0("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e10) {
                    throw new a0("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e10, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    identifier = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new a0("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + ":" + path, "raw", null);
                if (identifier == 0) {
                    throw new a0("Resource not found.", null, 2005);
                }
            }
            i = identifier;
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i);
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new a0("Resource is compressed: " + uriNormalizeScheme, null, 2000);
            }
            this.A = assetFileDescriptorOpenRawResourceFd;
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.A.getFileDescriptor());
            this.B = fileInputStream;
            try {
                if (length != -1 && j8 > length) {
                    throw new a0(null, null, 2008);
                }
                long startOffset = this.A.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j8) - startOffset;
                if (jSkip != j8) {
                    throw new a0(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.C = -1L;
                    } else {
                        long size = channel.size() - channel.position();
                        this.C = size;
                        if (size < 0) {
                            throw new a0(null, null, 2008);
                        }
                    }
                } else {
                    long j10 = length - jSkip;
                    this.C = j10;
                    if (j10 < 0) {
                        throw new j(2008);
                    }
                }
                if (j5 != -1) {
                    long j11 = this.C;
                    this.C = j11 == -1 ? j5 : Math.min(j11, j5);
                }
                this.D = true;
                e(mVar);
                return j5 != -1 ? j5 : this.C;
            } catch (a0 e11) {
                throw e11;
            } catch (IOException e12) {
                throw new a0(null, e12, 2000);
            }
        } catch (Resources.NotFoundException e13) {
            throw new a0(null, e13, 2005);
        }
    }

    @Override // v1.h
    public final Uri o() {
        m mVar = this.f13121z;
        if (mVar != null) {
            return mVar.f13157a;
        }
        return null;
    }

    @Override // p1.i
    public final int read(byte[] bArr, int i, int i10) throws a0 {
        if (i10 == 0) {
            return 0;
        }
        long j5 = this.C;
        if (j5 != 0) {
            if (j5 != -1) {
                try {
                    i10 = (int) Math.min(j5, i10);
                } catch (IOException e10) {
                    throw new a0(null, e10, 2000);
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
            if (this.C != -1) {
                throw new a0("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }
}
