package com.qcloud.cos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains the results of listing the versions in an Qcloud COS bucket,
 * including a list of {@link COSVersionSummary} objects describing each version,
 * information describing if this is a complete or partial listing, and the
 * original request parameters.
 *
 * @see COS#listVersions(String, String)
 * @see COS#listVersions(ListVersionsRequest)
 * @see COS#listNextBatchOfVersions(VersionListing)
 */
public class VersionListing implements Serializable {

    /** A list of summary information describing the versions stored in the bucket */
    private List<COSVersionSummary> versionSummaries =
            new ArrayList<COSVersionSummary>();

    /**
     * A list of the common prefixes included in this version listing - common
     * prefixes will only be populated for requests that specified a delimiter
     */
    private List<String> commonPrefixes = new ArrayList<String>();

    /** The name of the Qcloud COS bucket containing the listed versions */
    private String bucketName;

    /**
     * The key marker to use in order to request the next page of results - only
     * populated if the isTruncated member indicates that this version listing
     * is truncated
     */
    private String nextKeyMarker;

    /**
     * The version ID marker to use in order to request the next page of results
     * - only populated if the isTruncated member indicates that this version
     * listing is truncated
     */
    private String nextVersionIdMarker;

    /**
     * Indicates if this is a complete listing, or if the caller needs to make
     * additional requests to Qcloud COS to see the full object listing for an COS
     * bucket
     */
    private boolean isTruncated;


    /* Original Request Parameters */

    /**
     * The prefix parameter originally specified by the caller when this version
     * listing was returned
     */
    private String prefix;

    /**
     * The key marker parameter originally specified by the caller when this
     * version listing was returned
     */
    private String keyMarker;

    /**
     * The version ID marker parameter originally specified by the caller when
     * this version listing was returned
     */
    private String versionIdMarker;

    /**
     * The maxKeys parameter originally specified by the caller when this
     * version listing was returned
     */
    private int maxKeys;

    /**
     * The delimiter parameter originally specified by the caller when this
     * version listing was returned
     */
    private String delimiter;

    /**
     * The encodingType parameter originally specified by the caller when this
     * version listing was returned.
     */
    private String encodingType;


    /**
     * Gets the list of version summaries describing the versions stored in
     * the associated COS bucket. Callers should remember that listings for large
     * buckets can be truncated for performance reasons, so callers might need
     * to make additional calls to
     * {@link COS#listVersions(ListVersionsRequest)} to get additional
     * results. Callers should always check {@link VersionListing#isTruncated()} to
     * determine if a listing is truncated or not.
     *
     * @return A list of the version summaries describing the versions stored in
     *         the associated COS bucket.
     */
    public List<COSVersionSummary> getVersionSummaries() {
        return this.versionSummaries;
    }

    /**
     * For internal use only. Sets the list of version
     * summaries describing the versions stored in the associated COS bucket.
     *
     * @param versionSummaries
     *            The version summaries describing the versions stored in the
     *            associated COS bucket.
     */
    public void setVersionSummaries(List<COSVersionSummary> versionSummaries) {
        this.versionSummaries = versionSummaries;
    }

    /**
     * Gets the common prefixes included in this version listing. Common
     * prefixes are only present if a delimiter was specified in the original
     * request.
     * <p>
     * Each common prefix represents a set of keys in the COS bucket that have
     * been condensed and omitted from the version summary results. This allows
     * applications to organize and browse their keys hierarchically,
     * similar to how a file system organizes files
     * into directories.
     * <p>
     * For example, consider a bucket that contains the keys:
     * <ul>
     *  <li>"foo/bar/baz"</li>
     *  <li>"foo/bar/bash"</li>
     *  <li>"foo/bar/bang"</li>
     *  <li>"foo/boo"</li>
     * </ul>
     * If calling <code>listVersions</code> with a prefix value of "foo/" and a delimiter
     * value of "/" on this
     * bucket, the returned <code>VersionListing</code> will contain one entry in the
     * common prefixes list ("foo/bar/") and none of the keys beginning with
     * that common prefix will be included in the version summaries list.
     * </p>
     *
     * @return The list of common prefixes included in this version listing.
     *         Returns an empty list if no common prefixes are found.
     */
    public List<String> getCommonPrefixes() {
        return commonPrefixes;
    }

    /**
     * For internal use only. Sets the common prefixes for this
     * version listing, representing the key prefixes that were rolled up
     * because of the request's delimiter parameter.
     *
     * @param commonPrefixes
     *            The common prefixes for this version listing.
     */
    public void setCommonPrefixes(List<String> commonPrefixes) {
        this.commonPrefixes = commonPrefixes;
    }

    /**
     * Gets the name of the Qcloud COS bucket containing the versions listed
     * in this {@link VersionListing}.
     *
     * @return The name of the Qcloud COS bucket containing the versions listed
     *         in this COSVersionListingVersionListing.
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * For internal use only. Sets the name of the Qcloud COS
     * bucket containing the versions listed in this COSVersionListing.
     *
     * @param bucketName
     *            The name of the Qcloud COS bucket containing the versions
     *            listed in this COSVersionListing.
     */
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    /**
     * The prefix parameter originally used to request this version listing, or
     * <code>null</code> if no prefix was specified. All object keys included in this version
     * listing start with the specified prefix.
     *
     * @return The prefix parameter originally used to request this version
     *         listing, or <code>null</code> if no prefix was specified.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * For internal use only. Sets the prefix parameter
     * originally used to request this version listing.
     *
     * @param prefix
     *            The prefix parameter originally used to request this version
     *            listing.
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * The key marker parameter originally used to request this version listing,
     * or <code>null</code> if no key marker was specified. If specified, all object keys
     * included in this version listing will occur lexically (alphabetically)
     * after the specified key marker.
     *
     * @return The key marker parameter originally used to request this version
     *         listing, or <code>null</code> if no key marker was specified.
     */
    public String getKeyMarker() {
        return keyMarker;
    }

    /**
     * For internal use only. Sets the key marker parameter
     * originally used to request this version listing.
     *
     * @param keyMarker
     *            The key marker parameter originally used to request this
     *            version listing.
     */
    public void setKeyMarker(String keyMarker) {
        this.keyMarker = keyMarker;
    }

    /**
     * Gets the value of the version ID marker parameter used to request this version
     * listing. Returns <code>null</code> if no version ID marker was otherwise specified.
     *
     * @return The version ID marker parameter originally used to request this
     *         version listing. Returns <code>null</code> if no version ID marker otherwise was specified.
     */
    public String getVersionIdMarker() {
        return versionIdMarker;
    }

    /**
     * For internal use only. Sets the version ID marker
     * parameter originally used to request this version listing.
     *
     * @param versionIdMarker
     *            The version ID marker parameter originally used to request
     *            this version listing.
     */
    public void setVersionIdMarker(String versionIdMarker) {
        this.versionIdMarker = versionIdMarker;
    }

    /**
     * Gets the value of the <code>maxKeys</code> parameter used to request this version
     * listing.  Returns the default <code>maxKeys</code> value provided by Qcloud COS if no
     * parameter value was otherwise specified.
     * <p>
     * The <code>maxKeys</code> parameter limits the number
     * of versions included in this version listing. A version listing will
     * never contain more versions than indicated by <code>maxKeys</code> , but can
     * contain less.
     * </p>
     *
     * @return The value of the <code>maxKeys</code> parameter used to request this version
     *         listing.  Returns the default <code>maxKeys</code> value provided by Qcloud COS if no
     *         parameter value was otherwise specified.
     */
    public int getMaxKeys() {
        return maxKeys;
    }

    /**
     * For internal use only. Sets the maxKeys parameter
     * originally used to request this object listing, or the default maxKeys
     * applied by Qcloud COS if the requester didn't specify a value.
     *
     * @param maxKeys
     *            The maxKeys parameter originally used to request this version
     *            listing, or the default maxKeys value applied by Qcloud COS if
     *            the requester didn't specify a value.
     */
    public void setMaxKeys(int maxKeys) {
        this.maxKeys = maxKeys;
    }

    /**
     * Gets the value of the <code>delimiter</code> parameter used to request this version
     * listing. Returns <code>null</code> if no parameter value was otherwise specified.
     * <p>
     * The delimiter value allows
     * callers to condense COS keys into common prefix listings. For example, if
     * a caller specifies a delimiter of "/" (a common used value for
     * delimiter), then any keys that contain a common prefix between the start
     * of the key and the first occurrence of "/" will not be included in the
     * list of object summaries; instead, the common prefixes list will have
     * one entry for the common prefix.
     * </p>
     *
     * @return The delimiter parameter originally used to request this version
     *         listing, or <code>null</code> if none was specified.
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * For internal use only. Sets the delimiter parameter
     * originally used to request this version listing.
     *
     * @param delimiter
     *            The delimiter parameter originally used to request this
     *            version listing.
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    /**
     * Gets the key marker to use in
     * the next <code>listVersions</code> request in order to obtain the next page of results.
     * Returns <code>null</code> if the version listing is not truncated.
     * For truncated requests,
     * this value is equal to the greatest (lexicographically) value of the
     * object keys included in this listing.
     *
     * @return The key marker to use in
     *         the next <code>listVersions</code> request in order to obtain the next page of results.
     *         Returns <code>null</code> if the version listing is not truncated.
     *
     * @see VersionListing#isTruncated()
     */
    public String getNextKeyMarker() {
        return nextKeyMarker;
    }

    /**
     * For internal use only. Sets the key marker to use in the
     * next listVersions request in order to see the next page of results for a
     * truncated version listing.
     *
     * @param marker
     *            The key marker to use in the next listVersions request in
     *            order to see the next page of results for a truncated version
     *            listing.
     */
    public void setNextKeyMarker(String marker) {
        this.nextKeyMarker = marker;
    }

    /**
     * Gets the version ID marker to
     * use in the next <code>listVersions</code> request in order to obtain the next page of
     * results. Returns <code>null</code> if the version listing is not truncated.
     *
     * @return The version ID marker to use in the next <code>listVersions</code> request in
     *         order to see the next page of results.
     *         Returns <code>null</code> if the version listing is not truncated.
     *
     * @see VersionListing#isTruncated()
     */
    public String getNextVersionIdMarker() {
        return nextVersionIdMarker;
    }

    /**
     * For internal use only. Sets the version ID marker to use
     * in the next listVersions request in order to see the next page of results
     * for a truncated version listing.
     *
     * @param marker
     *            The version ID marker to use in the next listVersions request
     *            in order to obtain the next page of results for a truncated
     *            version listing.
     */
    public void setNextVersionIdMarker(String marker) {
        this.nextVersionIdMarker = marker;
    }

    /**
     * Gets whether or not the version listing
     * is complete, indicating if additional calls to Qcloud COS are needed to obtain
     * complete version listing results.
     *
     * @return The value <code>true</code> if this version listing is <b>not complete<b>, indicating
     *         additional calls to Qcloud COS are needed to obtain
     *         complete version listing results. Returns the value <code>false</code> if otherwise.
     */
    public boolean isTruncated() {
        return isTruncated;
    }

    /**
     * For internal use only. Sets the truncated property for
     * this version listing, indicating if this is a complete listing or not and
     * whether the caller needs to make additional calls to COS to get more
     * version summaries.
     *
     * @param isTruncated
     *            True if this version listing is <b>not complete</b> and the
     *            caller needs to make additional COS calls to get additional
     *            version summaries.
     */
    public void setTruncated(boolean isTruncated) {
        this.isTruncated = isTruncated;
    }

    /**
     * Gets the encoding type used by Qcloud COS to encode object key names in
     * the XML response. If you specify <code>encodingType</code> request
     * parameter, Qcloud COS includes this element in the response, and returns
     * encoded key name values in the following response elements:
     * <code>KeyMarker, NextKeyMarker, Prefix, Key, Delimiter</code>.
     *
     * @return <code>Null</code> if <code>encodingType</code> is not specified
     *         in the request parameter.
     */
    public String getEncodingType() {
        return encodingType;
    }

    /**
     * For internal use only. Sets the encoding type used by Qcloud COS to encode
     * object key names in the XML response.
     *
     * @param encodingType
     *            <code>Null</code> if <code>encodingType</code> is not
     *            specified in the request parameter.
     */
    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

}