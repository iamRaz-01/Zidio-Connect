# Entity and Attributes 
---

## User Entity

| Attribute | Type | Description | Constraints |
| --- | --- | --- | --- |
| `user_id` | UUID / INT | Unique identifier | `PRIMARY KEY`, `NOT NULL` |
| `role` | Enum | 'STUDENT' or 'RECRUITER' | `NOT NULL`, `CHECK (role IN ('STUDENT', 'RECRUITER','ADMIN'))` |
| `full_name` | String | Full name of the user | `NOT NULL`, `CHECK (LENGTH(full_name) > 1)` |
| `email` | String | Login email | `NOT NULL`, `UNIQUE`, `CHECK (email LIKE '%@%.%')` |
| `password_hash` | String | Encrypted password | `NOT NULL` |
| `phone_number` | String | Contact number | `NOT NULL`, `CHECK (phone_number ~ '^[0-9]{10,15}$')` |
| `profile_picture_url` | String | Optional profile picture | `NULLABLE` |
| `address` | String | City or region | `NULLABLE` |
| `created_at` | Timestamp | Account creation date | `DEFAULT CURRENT_TIMESTAMP`, `NOT NULL` |
| `updated_at` | Timestamp | Last profile update | `DEFAULT CURRENT_TIMESTAMP`, `NOT NULL` |

## Student Entity

| Attribute | Type | Description | Constraints |
| --- | --- | --- | --- |
| `student_id` | UUID / INT | FK to `user.user_id` | `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL` |
| `date_of_birth` | Date | For eligibility | `NOT NULL` |
| `gender` | String | Optional | `NULLABLE`, `CHECK (gender IN ('Male', 'Female', 'Other'))` |
| `college_name` | String | Enrolled institution | `NOT NULL` |
| `enrollment_number` | String | College roll number | `NOT NULL`, `UNIQUE` |
| `course` | String | Course like B.Tech, BCA | `NOT NULL` |
| `year_of_study` | Enum | 1st, 2nd, etc. | `NOT NULL`, `CHECK (year_of_study IN ('1st', '2nd', '3rd', '4th'))` |
| `department` | String | Department | `NOT NULL` |

## Recruiter Entity

| Attribute | Type | Description | Constraints |
| --- | --- | --- | --- |
| `recruiter_id` | UUID / INT | FK to `user.user_id` | `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL` |
| `designation` | String | e.g., HR Manager | `NOT NULL`, `CHECK (LENGTH(designation) > 1)` |
| `company_name` | String | Organization name | `NOT NULL` |
| `company_website` | String | Optional – Info page | `NULLABLE`, `CHECK (company_website LIKE 'http%' OR company_website IS NULL)` |
| `company_logo_url` | String | Optional – logo | `NULLABLE` |
| `account_status` | Enum | Status of recruiter account | `NOT NULL`, `CHECK (account_status IN ('Active', 'Suspended', 'Pending'))` |
| `verified_by_admin` | Boolean | Admin-approved status | `NOT NULL`, `DEFAULT FALSE` |

## Admin Entity

| Attribute | Type | Description | Constraints |
| --- | --- | --- | --- |
| `admin_id` | UUID / INT | FK to `user.user_id` | `PRIMARY KEY`, `FOREIGN KEY`, `NOT NULL` |
| `admin_role` | Enum | Type of admin – e.g., 'SuperAdmin', 'Moderator' | `NOT NULL`, `CHECK (admin_role IN ('SuperAdmin', 'Moderator'))` |
| `permissions_level` | Integer | Defines scope of access (e.g., 1 = read-only) | `NOT NULL`, `CHECK (permissions_level BETWEEN 1 AND 5)` |
| `last_login` | Timestamp | Last time the admin accessed the system | `NULLABLE` |
| `is_active` | Boolean | Admin status | `NOT NULL`, `DEFAULT TRUE` |
